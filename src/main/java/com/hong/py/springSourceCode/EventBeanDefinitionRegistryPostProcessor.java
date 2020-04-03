package com.hong.py.springSourceCode;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/3 9:16
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/3 9:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 *
 **/
@Component
public class EventBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private BeanDefinitionRegistry registry;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        this.registry=registry;
    }

    /**
     * 注入自定义的多播器(MyApplicationEventMulticaster)，支持异步发布
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(MyApplicationEventMulticaster.class);
        ConstructorArgumentValues argumentValues=new ConstructorArgumentValues();
        argumentValues.addGenericArgumentValue(beanFactory);
        beanDefinition.setConstructorArgumentValues(argumentValues);
        this.registry.registerBeanDefinition("applicationEventMulticaster",beanDefinition);
    }


}
