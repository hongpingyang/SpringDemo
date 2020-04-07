package com.hong.py.springSourceCode.SelfAop.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.SelfTransactioManage
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/7 10:13
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/7 10:13
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
public class AopUtils {

    public static Object invokeJoinpointUsingReflection(Object targetClass, Method method,Object[] args) throws Throwable {
        try {
            method.setAccessible(true);
            return method.invoke(targetClass, args);
        } catch (IllegalAccessException ex) {
           throw ex;
        } catch (InvocationTargetException ex) {
            throw ex.getTargetException();
        }
    }
}
