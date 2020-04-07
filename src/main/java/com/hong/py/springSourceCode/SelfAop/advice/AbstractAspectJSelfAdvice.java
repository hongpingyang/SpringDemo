package com.hong.py.springSourceCode.SelfAop.advice;

import com.hong.py.springSourceCode.SelfAop.utils.AopUtils;
import org.springframework.beans.factory.BeanFactory;

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

    /**
     * 调用切面的方法。 没有支持入参
     * @return
     */
    public Object invokeMethod() throws Throwable {
        return AopUtils.invokeJoinpointUsingReflection(this.beanFactory.getBean(aspectClass), method, new Object[]{});
    }

}
