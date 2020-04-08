package com.hong.py;

import com.hong.py.service.IAccountService2;
import com.hong.py.serviceImpl.AccountService2Impl;
import com.hong.py.serviceImpl.AccountService2Impl2;
import com.hong.py.serviceImpl.ChildBean;
import com.hong.py.springSourceCode.ObjectProviderDemo;
import com.hong.py.springSourceCode.TestListener1;
import com.hong.py.springSourceCode.SelfAop.test.AspectPrint;
import com.hong.py.springSourceCode.test.SelfAspectPrint;
import com.hong.py.springSourceCode.test.TransactionPrint;
import org.junit.Test;
import org.junit.runner.RunWith;
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


}
