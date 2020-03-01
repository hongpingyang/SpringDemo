package com.hong.py;

import com.hong.py.service.IAccountService;
import com.hong.py.service.IAccountService2;
import com.hong.py.service.IAccountService3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class springtest {


    @Autowired
    public IAccountService accountservicefactory1;

    @Autowired
    public IAccountService2 accountService2;

    @Autowired
    public IAccountService2 accountService2Impl2;

    @Autowired
    public IAccountService3 accountServiceImpl4;

    @Autowired
    public IAccountService3 accountServiceImpl5;

    @Test
    public void testSpringIoc() {
        accountservicefactory1.AddAccount();
    }

    @Test
    public void testSpringAop() {
        accountService2.AddAccount();
        accountService2.deleteAccount();
        accountService2.UpdateAccount(2);
    }

    @Test
    public void testSpringAnnotationAop() {
        accountService2Impl2.AddAccount();
        accountService2Impl2.deleteAccount();
        accountService2Impl2.UpdateAccount(2);
    }

    @Test
    public void testSpringTxAop() {
        accountServiceImpl4.TransferAccount();
    }

    @Test
    public void testSpringTxAnnotationAop() {
        accountServiceImpl5.TransferAccount();
    }


}
