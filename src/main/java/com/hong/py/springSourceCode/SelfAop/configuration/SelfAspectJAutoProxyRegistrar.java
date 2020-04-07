package com.hong.py.springSourceCode.SelfAop.configuration;

import com.hong.py.springSourceCode.SelfAop.autoProxyCreator.SelfAnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


public class SelfAspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar {

    public static final String AUTO_PROXY_CREATOR_BEAN_NAME =
            "org.springframework.aop.config.selfInternalAutoProxyCreator";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(SelfAnnotationAwareAspectJAutoProxyCreator.class);
        beanDefinition.setSource(null);
        //beanDefinition.getPropertyValues().add("order", Ordered.HIGHEST_PRECEDENCE);
        beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        registry.registerBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME, beanDefinition);
    }
}
