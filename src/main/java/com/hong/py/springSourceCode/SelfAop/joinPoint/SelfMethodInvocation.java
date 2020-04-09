package com.hong.py.springSourceCode.SelfAop.joinPoint;

import com.hong.py.springSourceCode.SelfAop.utils.AopUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.SelfAop.joinPoint
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/7 9:54
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/7 9:54
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
public class SelfMethodInvocation implements JoinPoint {

    private List<Object> selfMethodInterceptors;

    private int currentIndex=-1;

    private Object tagetClass;

    private Method method;

    private Object[] args;

    public Object getTagetClass() {
        return tagetClass;
    }

    public void setTagetClass(Object tagetClass) {
        this.tagetClass = tagetClass;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public SelfMethodInvocation(Object tagetClass,Method method,Object[] args,List<Object> selfMethodInterceptors) {
        this.tagetClass=tagetClass;
        this.method=method;
        this.args=args;
        this.selfMethodInterceptors = selfMethodInterceptors;
    }

    @Override
    public Object proceed() throws Throwable {

        if (currentIndex == this.selfMethodInterceptors.size() - 1) {
            //反射调用
           return AopUtils.invokeJoinpointUsingReflection(tagetClass, method, args);
        }
        currentIndex++;
        Object methodInterceptor = this.selfMethodInterceptors.get(currentIndex);

        return ((SelfMethodInterceptor)methodInterceptor).invoke(this);
    }

}
