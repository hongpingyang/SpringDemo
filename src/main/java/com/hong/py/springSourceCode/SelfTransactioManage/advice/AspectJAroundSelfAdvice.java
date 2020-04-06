package com.hong.py.springSourceCode.SelfTransactioManage.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

public class AspectJAroundSelfAdvice extends AbstractAspectJSelfAdvice implements MethodInterceptor {

    public AspectJAroundSelfAdvice(Method method, Class<?> aspectClass, BeanFactory beanFactory) {
        super(method, aspectClass, beanFactory);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }


}
