package com.hong.py.springSourceCode.SelfTransactioManage.interceptor;

import com.hong.py.springSourceCode.SelfAop.advice.SelfAdvice;
import com.hong.py.springSourceCode.SelfAop.joinPoint.SelfMethodInterceptor;
import com.hong.py.springSourceCode.SelfAop.joinPoint.SelfMethodInvocation;
import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionAttribute;
import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionAttributeSource;
import com.hong.py.springSourceCode.SelfTransactioManage.manager.SelfPlatformTransactionManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.core.Ordered;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

public class SelfTransactionInterceptor implements SelfAdvice, SelfMethodInterceptor, BeanFactoryAware, Ordered {

    private SelfTransactionAttributeSource selfTransactionAttributeSource;

    private BeanFactory beanFactory;


    public void setTransactionAttributeSource(SelfTransactionAttributeSource selfTransactionAttributeSource) {
        this.selfTransactionAttributeSource=selfTransactionAttributeSource;
    }

    @Override
    public Object invoke(SelfMethodInvocation invocation) throws Throwable {
        return invokeWithinTransaction(invocation.getMethod(), invocation.getTagetClass().getClass(), invocation::proceed);
    }

    /**
     * 没有考虑事务的一些特性
     * @param method
     * @param targetClass
     * @param invocation
     * @return
     * @throws Throwable
     */
    public Object invokeWithinTransaction(Method method, Class<?> targetClass, final InvocationCallback invocation) throws Throwable {

        SelfTransactionAttribute attr = this.selfTransactionAttributeSource.getTransactionAttribute(method, targetClass);
        if (attr != null) {

            SelfPlatformTransactionManager manager = determineTransactionManager(attr);
            Connection connection = createTransactionIfNecessary(manager);

            Object retVal;
            try {
                // This is an around advice: Invoke the next interceptor in the chain.
                // This will normally result in a target object being invoked.
                retVal = invocation.proceedWithInvocation();
                commitTransactionAfterReturning(manager,connection);
            }
            catch (Throwable ex) {
                completeTransactionAfterThrowing(attr,manager,connection, ex);
                throw ex;
            }
            finally {
                connection.close();
            }
            return retVal;
        }
        else //非事务的
        {
            try {
                return  invocation.proceedWithInvocation();
            } catch (Throwable throwable) {
                throw throwable;
            }
            finally {
                return null;
            }
        }
    }



    /**
     * 获取连接
     * @param manager
     * @return
     */
    private Connection createTransactionIfNecessary(SelfPlatformTransactionManager manager) throws SQLException {
        Connection connection = manager.getConnection();

        if (connection.getAutoCommit()) {
            connection.setAutoCommit(false);
        }

        return connection;
    }

    private void commitTransactionAfterReturning(SelfPlatformTransactionManager manager,Connection connection) throws SQLException {
        manager.commit(connection);
    }

    private void completeTransactionAfterThrowing(SelfTransactionAttribute attr, SelfPlatformTransactionManager manager,Connection connection, Throwable ex) throws SQLException {
        if (attr.rollbackOn(ex)) {
            manager.rollback(connection);
        }
        else {
            manager.commit(connection);
        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
       this.beanFactory=beanFactory;
    }


    /**
     * 获取事务管理器
     * @param attribute
     * @return
     */
    protected SelfPlatformTransactionManager determineTransactionManager(SelfTransactionAttribute attribute) {
        if (attribute.getName() != null && !attribute.getName().isEmpty()) {
            SelfPlatformTransactionManager selfPlatformTransactionManager = BeanFactoryAnnotationUtils.qualifiedBeanOfType(this.beanFactory,
                    SelfPlatformTransactionManager.class, attribute.getName());
            return selfPlatformTransactionManager;
        }
        else {
            SelfPlatformTransactionManager selfPlatformTransactionManager = BeanFactoryUtils.beanOfTypeIncludingAncestors((ListableBeanFactory) this.beanFactory, SelfPlatformTransactionManager.class, false, true);
            return selfPlatformTransactionManager;
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }

    protected interface InvocationCallback {

        Object proceedWithInvocation() throws Throwable;
    }

}
