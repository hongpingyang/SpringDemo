package com.hong.py.serviceImpl;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * 自定义拦截器
 */
public class adviseMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result=null;
        try{
            System.out.println("方法执行之前："+invocation.getMethod().toString());

            result= invocation.proceed();

            System.out.println("方法执行之后："+invocation.getMethod().toString());
            System.out.println("方法正常运行结果："+result);
            return result;
        }catch (Exception e){
            System.out.println("方法出现异常:"+e.toString());
            System.out.println("方法运行Exception结果："+result);
            return result;
        }
    }
}
