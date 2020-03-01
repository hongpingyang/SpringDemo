package com.hong.py.serviceImpl;

import com.hong.py.dao.AccountServiceDao;
import com.hong.py.service.IAccountService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
@EnableTransactionManagement
public class AccountServiceImpl5 implements IAccountService3   {

    @Autowired
    private AccountServiceDao accountServiceDao;

    /**
     * 新增账户
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void AddAccount() {
        //accountServiceDao.AddMoney();
    }

    /**
     * 账户转账
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void TransferAccount() {

        accountServiceDao.AddMoney(3, BigDecimal.valueOf(-200));
        int i=10/0; //出现异常事务要回滚
        accountServiceDao.AddMoney(4, BigDecimal.valueOf(200));

    }
}
