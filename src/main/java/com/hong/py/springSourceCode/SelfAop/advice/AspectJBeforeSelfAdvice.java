package com.hong.py.springSourceCode.SelfAop.advice;

import com.hong.py.springSourceCode.SelfAop.joinPoint.SelfMethodInterceptor;
import com.hong.py.springSourceCode.SelfAop.joinPoint.SelfMethodInvocation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.Ordered;

import java.lang.reflect.Method;

public class AspectJBeforeSelfAdvice extends AbstractAspectJSelfAdvice implements SelfMethodInterceptor, Ordered {


    public AspectJBeforeSelfAdvice(Method method, Class<?> aspectClass, BeanFactory beanFactory) {
        super(method, aspectClass, beanFactory);
    }

    @Override
    public Object invoke(SelfMethodInvocation invocation) throws Throwable {
        invokeMethod();
        return invocation.proceed();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
