package com.hong.py.factory;

import com.hong.py.serviceImpl.AccountServiceImpl;

import java.util.Date;

/**
 * 工厂类
 */
public class AccountFactory {

    public AccountServiceImpl getAccountServiceImpl() {

        return new AccountServiceImpl("洪大屌",23, new Date(1990,9,15));
    }
}
