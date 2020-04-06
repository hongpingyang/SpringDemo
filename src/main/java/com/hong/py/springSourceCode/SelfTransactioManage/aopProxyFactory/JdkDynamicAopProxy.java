package com.hong.py.springSourceCode.SelfTransactioManage.aopProxyFactory;

import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicAopProxy implements SelfAopProxy, InvocationHandler {


    private final  SelfAdvisedSupport advisedSupport;

    public JdkDynamicAopProxy(SelfAdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    @Override
    public Object getProxy() {
        return getProxy(ClassUtils.getDefaultClassLoader());
    }

    public Object getProxy(ClassLoader classLoader) {
        Class<?>[] proxiedInterfaces = advisedSupport.getTarget().getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, proxiedInterfaces, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

}
