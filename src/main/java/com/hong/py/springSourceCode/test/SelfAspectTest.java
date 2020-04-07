package com.hong.py.springSourceCode.test;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.SelfAop.test
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/7 11:23
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/7 11:23
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
//@Component
@Aspect
public class SelfAspectTest {

    @Pointcut("execution(* *.aspectPrint(..))")
    public void test() {

    }

    @Pointcut("execution(* *.aspectPrint1(..))")
    public void test1() {

    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("before");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("after");
    }


    @Before("test1()")
    public void beforeTest1() {
        System.out.println("before1");
    }

    @After("test1()")
    public void afterTest1() {
        System.out.println("after1");
    }

}
