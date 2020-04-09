package com.hong.py.springSourceCode.SelfTransactioManage.configuration;


import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfAnnotationTransactionAttributeSource;
import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionAttributeSource;
import com.hong.py.springSourceCode.SelfTransactioManage.interceptor.SelfTransactionInterceptor;
import com.hong.py.springSourceCode.SelfTransactioManage.selfAdvisor.SelfBeanFactoryTransactionAttributeSourceAdvisor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

/**
 * 注入默认的增强器
 */
@Configuration
public class SelfProxyTransactionManagementConfiguration  {


    @Bean(name = "org.springframework.transaction.config.selfInternalTransactionAdvisor")
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public SelfBeanFactoryTransactionAttributeSourceAdvisor transactionAdvisor() {

        SelfBeanFactoryTransactionAttributeSourceAdvisor advisor = new SelfBeanFactoryTransactionAttributeSourceAdvisor();
        advisor.setTransactionAttributeSource(transactionAttributeSource());
        advisor.setAdvice(transactionInterceptor());

        return advisor;
    }

    /**
     * 用来处理Transactional注解的
     * @return
     */
    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public SelfTransactionAttributeSource transactionAttributeSource() {
        return new SelfAnnotationTransactionAttributeSource();
    }

    /**
     * 拦截器
     * @return
     */
    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public SelfTransactionInterceptor transactionInterceptor() {
        SelfTransactionInterceptor interceptor = new SelfTransactionInterceptor();
        interceptor.setTransactionAttributeSource(transactionAttributeSource());
        //事务管理器后面主动获取
        /*if (this.txManager != null) {
            interceptor.setTransactionManager(this.txManager);
        }*/
        return interceptor;
    }


}
