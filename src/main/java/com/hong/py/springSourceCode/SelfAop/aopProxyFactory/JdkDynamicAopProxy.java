package com.hong.py.springSourceCode.SelfAop.aopProxyFactory;

import com.hong.py.springSourceCode.SelfAop.joinPoint.SelfMethodInvocation;
import com.hong.py.springSourceCode.SelfAop.utils.AopUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

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

        Class<?> targetClass = this.advisedSupport.getTarget().getClass();

        List<Object> chains = this.advisedSupport.getChainInterceptors(method, targetClass);

        Object val;
        if (chains.isEmpty()) {
            //直接反射调用
            val=AopUtils.invokeJoinpointUsingReflection(proxy, method, args);
        }else {

            SelfMethodInvocation methodInvocation = new SelfMethodInvocation(proxy, method, args,chains);
            val=methodInvocation.proceed();
        }

        return val;
    }

}
