package com.hong.py.factory;

import com.hong.py.serviceImpl.AccountServiceImpl;

import java.util.Date;

public class AccountStaticFactory {

    public static AccountServiceImpl getAccountServiceImpl() {

        return new AccountServiceImpl("洪大屌",23, new Date(1990,9,15));
    }
}
