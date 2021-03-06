package com.hong.py.springSourceCode.SelfAop.advice;

import com.hong.py.springSourceCode.SelfAop.joinPoint.SelfMethodInterceptor;
import com.hong.py.springSourceCode.SelfAop.joinPoint.SelfMethodInvocation;
import org.springframework.beans.factory.BeanFactory;

import java.lang.reflect.Method;

public class AspectJAroundSelfAdvice extends AbstractAspectJSelfAdvice implements SelfMethodInterceptor {

    public AspectJAroundSelfAdvice(Method method, Class<?> aspectClass, BeanFactory beanFactory) {
        super(method, aspectClass, beanFactory);
    }


    @Override
    public Object invoke(SelfMethodInvocation invocation) throws Throwable {

        return null;
    }
}
