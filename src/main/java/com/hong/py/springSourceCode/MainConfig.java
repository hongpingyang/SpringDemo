package com.hong.py.springSourceCode;

import com.hong.py.serviceImpl.AccountService2Impl2;
import com.hong.py.serviceImpl.ChildBean;
import com.hong.py.springSourceCode.SelfAop.annotation.SelfEnableAspectJAutoProxy;
import com.hong.py.springSourceCode.SelfAop.test.SelfAspectPrint;
import com.hong.py.springSourceCode.test.SelfAspectTest;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/2 9:58
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/2 9:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
@Configuration
//@ComponentScan(value ={"com.hong.py.springSourceCode"} )
//会提示不能重复
//@Import(value = com.hong.py.springSourceCode.MyImportSelector.class )
//@Import(value = com.hong.py.springSourceCode.MyImportBeanDefinitionRegistrar.class)
//@EnableAspectJAutoProxy //开启
@SelfEnableAspectJAutoProxy
//@EnableTransactionManagement
@ComponentScan(value = "com.hong.py.springSourceCode.SelfAop.test")
public class MainConfig {

    /*//beanName可以重复，但只有第一个会起作用
    @Bean("childBean")
    public ChildBean childBean() {
        ChildBean childBean = new ChildBean();
        childBean.setAge(18);
        childBean.setName("洪大洋");
        childBean.setHeight(180);
        return childBean;
    }

    //beanName可以重复，但只有第一个会起作用
    @Bean("childBean")
    public ChildBean childBean1() {
        ChildBean childBean = new ChildBean();
        childBean.setAge(18);
        childBean.setName("洪小洋");
        childBean.setHeight(180);
        return childBean;
    }

    //
    @Bean()
    public ChildBean childBean2() {
        ChildBean childBean = new ChildBean();
        childBean.setAge(18);
        childBean.setName("洪小洋");
        childBean.setHeight(180);
        return childBean;
    }

    @Bean
    public AccountService2Impl2 accountService2Impl2() {
        AccountService2Impl2 accountService2Impl2 = new AccountService2Impl2();
        return accountService2Impl2;
    }
*/
    @Bean
    public SelfAspectPrint selfAspectPrint() {
        SelfAspectPrint selfAspectPrint = new SelfAspectPrint();
        return selfAspectPrint;
    }


}
