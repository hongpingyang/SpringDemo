package com.hong.py.springSourceCode.SelfAop.test;

import com.hong.py.springSourceCode.SelfAop.annotation.SelfAfter;
import com.hong.py.springSourceCode.SelfAop.annotation.SelfAspect;
import com.hong.py.springSourceCode.SelfAop.annotation.SelfBefore;
import com.hong.py.springSourceCode.SelfAop.annotation.SelfPointcutA;
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
@Component
@SelfAspect
public class SelfAspectTest {

    @SelfPointcutA("execution(* *.aspectPrint(..))")
    public void test() {

    }

    /*@Pointcut("execution(* *.SelfAspectPrint.aspectPrint1(..))")
    public void test1() {

    }*/

    @SelfAfter("test()")
    public void afterTest() {
        System.out.println("after");
    }

    @SelfBefore("test()")
    public void beforeTest() {
        System.out.println("before");
    }




    /*@SelfBefore("test1()")
    public void beforeTest1() {
        System.out.println("before1");
    }

    @SelfAfter("test1()")
    public void afterTest1() {
        System.out.println("after1");
    }*/

}
