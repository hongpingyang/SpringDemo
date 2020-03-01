package com.hong.py.serviceImpl;

import com.hong.py.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    int account=1;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void AddAccount() {
        System.out.println(account);
        System.out.println("添加账户:"+name+"->"+age+"->"+birthday);
        account++;
    }


    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", account=" + account +
                '}';
    }
}
