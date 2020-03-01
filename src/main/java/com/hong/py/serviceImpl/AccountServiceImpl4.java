package com.hong.py.serviceImpl;

import com.hong.py.dao.AccountServiceDao;
import com.hong.py.service.IAccountService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service

public class AccountServiceImpl4 implements IAccountService3 {

    @Autowired
    private AccountServiceDao accountServiceDao;

    /**
     * 新增账户
     */
    @Override
    public void AddAccount() {
        //accountServiceDao.AddMoney();
    }

    /**
     * 账户转账
     */
    @Override
    public void TransferAccount() {

        accountServiceDao.AddMoney(1, BigDecimal.valueOf(-100));
        //int i=10/0; //出现异常事务要回滚
        accountServiceDao.AddMoney(2, BigDecimal.valueOf(100));

    }
}
