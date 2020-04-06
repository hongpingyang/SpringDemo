package com.hong.py.springSourceCode.SelfTransactioManage.configuration;


import com.hong.py.springSourceCode.SelfTransactioManage.autoProxy.SelfInfrastructureAdvisorAutoProxyCreator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.Ordered;
import org.springframework.core.type.AnnotationMetadata;


/**
 * 加载selfInternalAutoProxyCreator
 */
public class SelfAutoProxyRegistrar implements ImportBeanDefinitionRegistrar {

    public static final String AUTO_PROXY_CREATOR_BEAN_NAME =
            "org.springframework.aop.config.selfInternalAutoProxyCreator";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        RootBeanDefinition beanDefinition = new RootBeanDefinition(SelfInfrastructureAdvisorAutoProxyCreator.class);
        beanDefinition.setSource(null);
        beanDefinition.getPropertyValues().add("order", Ordered.HIGHEST_PRECEDENCE);
        beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        registry.registerBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME, beanDefinition);

    }
}
