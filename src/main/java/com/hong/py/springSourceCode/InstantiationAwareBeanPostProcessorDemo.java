package com.hong.py.springSourceCode;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 为bean生成代理的后置处理器,会在createBean里调用都create Bean之前调用，判断如果postProcessBeforeInstantiation方法调用的返回结果
 * 不为null,这表明是这生成代理类。直接返回。
 * 注册是在容器准备时注册到容器中
 */
public class InstantiationAwareBeanPostProcessorDemo implements InstantiationAwareBeanPostProcessor {

        
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("===");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return null;
    }
}
