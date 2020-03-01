package com.hong.py.serviceImpl;

import com.hong.py.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl2 implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    int account=1;

    public void AddAccount() {
        System.out.println(account);
        System.out.println("添加账户:"+name+"->"+age+"->"+birthday);
        account++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
