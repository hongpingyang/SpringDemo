package com.hong.py.serviceImpl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.aspectPrint(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("before");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("after");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint joinPoint) {

        System.out.println("before1");
        Object o=null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }


}
