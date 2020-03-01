package com.hong.py.uti;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 记录日志的工具类
 */

public class Logger {

    /**
     * 打印日志 前置通知
     */

    private void beforeprintLog(){
        System.out.println("前置通知 打印日志");
    }

    /**
     * 打印日志 后置通知
     */
    private void afterprintLog(){
        System.out.println("后置通知 打印日志");
    }

    /**
     * 打印日志 最终通知
     */
    private void afterReturningprintLog(){
        System.out.println("最终通知 打印日志");
    }


    /**
     * 打印日志 异常通知
     */
    private void afterThrowingprintLog(){
        System.out.println("异常通知 打印日志");
    }

    /**
     * 打印日志 环绕通知
     *
     */
    private Object aroundprintLog(ProceedingJoinPoint proceedingJoinPoint){
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
