package com.hong.py;

import com.hong.py.service.IAccountService2;
import com.hong.py.serviceImpl.*;
import com.hong.py.springSourceCode.ObjectProviderDemo;
import com.hong.py.springSourceCode.TestListener1;
import com.hong.py.springSourceCode.SelfAop.test.AspectPrint;
import com.hong.py.springSourceCode.test.SelfAspectPrint;
import com.hong.py.springSourceCode.test.TransactionAspectJTest;
import com.hong.py.springSourceCode.test.TransactionPrint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/2 10:02
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/2 10:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.hong.py.springSourceCode.MainConfig.class})
public class SpringAnnotationTest implements ApplicationContextAware {

    /*@Autowired
    private ObjectProviderDemo objectProviderDemo;

    @Autowired
    private TestListener1 testListener1;

    @Autowired
    private List<ChildBean> childBeans;
*/
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    /*@Test
    public void testObjectProvider() {
        objectProviderDemo.printChildBean();
        if (this.childBeans.size() > 0) {
            for (ChildBean bean :
                    childBeans) {
                System.out.println(bean.toString());
            }
        }
    }*/

    /*@Test
    public void testApplicationListener() {
        testListener1.doSomeEvent();
    }*/

    @Test
    public void testAop() {
        //IAccountService2 accountService2Impl2 = (IAccountService2)applicationContext.getBean("accountService2Impl2");
        //accountService2Impl2.AddAccount();
        AspectPrint selfAspectPrint = (AspectPrint) applicationContext.getBean("selfAspectPrint");
        selfAspectPrint.aspectPrint();
        //selfAspectPrint.aspectPrint1();
    }

    @Test
    public void testTransaction() {
        TransactionPrint selfTransactionPrint = (TransactionPrint) applicationContext.getBean("selfTransactionPrint");
        selfTransactionPrint.aspectPrint();
    }

    @Test
    public void testTransactionAspectJ() {
        TransactionAspectJTest transactionAspectJTest = (TransactionAspectJTest)applicationContext.getBean("transactionAspectJTest");
        System.out.println("over");
        transactionAspectJTest.aspectPrint();
    }

    /**
     * 测试Aop的一些碰到的bug
     * CGLIB
     * JDK动态代理
     */
    @Test
    public void testAopBug() {


        ProxyFactory proxyFactory=new ProxyFactory();

        proxyFactory.setTarget(new TestMethodInterceptor());
        proxyFactory.addAdvice(new adviseMethodInterceptor()); // MethodInterceptor 继承 Interceptor extends SelfAdvice，所以才能加入
        proxyFactory.setInterfaces(ITestMethodInterceptor.class);

        TestMethodInterceptor proxy = (TestMethodInterceptor)proxyFactory.getProxy();
        //ITestMethodInterceptor proxy = (ITestMethodInterceptor)proxyFactory.getProxy();

        //getVal方法为final 导致代理没有代理这个方法。
        proxy.SetValue("这个是测试的");

        String val = proxy.getVal();//会输出null
        System.out.println(val);
    }
}
