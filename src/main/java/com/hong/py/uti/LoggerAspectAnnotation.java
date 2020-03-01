package com.hong.py.uti;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 记录日志的工具类
 */

@Component
@Aspect
public class LoggerAspectAnnotation {

    @Pointcut("execution(* com.hong.py.serviceImpl.AccountService2Impl2.*(..))" )
    private void pointcut1(){}
    /**
     * 打印日志 前置通知
     */
    @Before("pointcut1()")
    private void beforeprintLog(){
        System.out.println("前置通知 打印日志");
    }

    /**
     * 打印日志 后置通知
     */
    @After("pointcut1()")
    private void afterprintLog(){
        System.out.println("后置通知 打印日志");
    }

    /**
     * 打印日志 最终通知
     */
    @AfterReturning("pointcut1()")
    private void afterReturningprintLog(){
        System.out.println("最终通知 打印日志");
    }


    /**
     * 打印日志 异常通知
     */
    @AfterThrowing("pointcut1()")
    private void afterThrowingprintLog(){
        System.out.println("异常通知 打印日志");
    }

    /**
     * 打印日志 环绕通知
     *
     */
    //@Around("pointcut()")
    private Object aroundprintLog(ProceedingJoinPoint proceedingJoinPoint){
        return DoAround(proceedingJoinPoint);
    }

    private Object DoAround(ProceedingJoinPoint proceedingJoinPoint) {
        Object rtValue=null;
        System.out.println("环绕通知开始 打印日志");
        try {
            Object[] args=proceedingJoinPoint.getArgs();
            rtValue=proceedingJoinPoint.proceed(args); //调用切入点方法
            System.out.println("环绕通知结束 打印日志");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知异常 打印日志");
            throwable.printStackTrace();
        }finally {
            System.out.println("环绕通知最终 打印日志");
            return rtValue;
        }
    }
}
