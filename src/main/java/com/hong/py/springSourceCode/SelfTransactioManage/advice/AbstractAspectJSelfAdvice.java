package com.hong.py.springSourceCode.SelfTransactioManage.advice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

public abstract class AbstractAspectJSelfAdvice implements SelfAdvice {

    private Method method;

    private Class<?> aspectClass;

    private BeanFactory beanFactory;

    public AbstractAspectJSelfAdvice(Method method, Class<?> aspectClass, BeanFactory beanFactory) {

        this.method = method;
        this.aspectClass = aspectClass;
        this.beanFactory =beanFactory;
    }

}
