package com.hong.py.springSourceCode.SelfTransactioManage.configuration;


import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionAttributeSource;
import com.hong.py.springSourceCode.SelfTransactioManage.interceptor.SelfTransactionInterceptor;
import com.hong.py.springSourceCode.SelfTransactioManage.selfAdvisor.SelfBeanFactoryTransactionAttributeSourceAdvisor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.config.TransactionManagementConfigUtils;
import org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * 注入默认的增强器
 */
//@Configuration
public class SelfProxyTransactionManagementConfiguration  {


    @Bean(name = "org.springframework.transaction.config.selfInternalTransactionAdvisor")
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public SelfBeanFactoryTransactionAttributeSourceAdvisor transactionAdvisor() {

        SelfBeanFactoryTransactionAttributeSourceAdvisor advisor = new SelfBeanFactoryTransactionAttributeSourceAdvisor();
        //advisor.setTransactionAttributeSource(transactionAttributeSource());
        advisor.setAdvice(transactionInterceptor());

        return advisor;
    }

    /**
     * 用来处理Transactional注解的
     * @return
     */
    /*@Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public SelfTransactionAttributeSource transactionAttributeSource() {
        return new AnnotationTransactionAttributeSource();
    }*/

    /**
     * 拦截器
     * @return
     */
    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public SelfTransactionInterceptor transactionInterceptor() {
        SelfTransactionInterceptor interceptor = new SelfTransactionInterceptor();
        //interceptor.setTransactionAttributeSource(transactionAttributeSource());
        /*if (this.txManager != null) {
            interceptor.setTransactionManager(this.txManager);
        }*/
        return interceptor;
    }


}
