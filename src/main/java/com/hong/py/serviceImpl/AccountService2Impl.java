package com.hong.py.serviceImpl;

import com.hong.py.service.IAccountService2;

public class AccountService2Impl implements IAccountService2 {

    /**
     * 新增账户
     */
    @Override
    public void AddAccount() {
        System.out.println("新增账户");
        int i=10/0;
    }

    /**
     * 模拟更新账户
     *
     * @param i
     */
    @Override
    public void UpdateAccount(int i) {
        System.out.println("模拟更新账户");
    }

    /**
     * 删除账户
     *
     * @return
     */
    @Override
    public int deleteAccount() {
        System.out.println("删除账户");
        return 0;
    }
}
