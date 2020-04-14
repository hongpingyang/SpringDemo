package com.hong.py.springSourceCode.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.test
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/13 9:41
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/13 9:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
@Transactional
public class TransactionAspectJTest {

    @Autowired
    private AccountServiceDao accountServiceDao;

    public String aspectPrint() {
        accountServiceDao.AddMoney(1, BigDecimal.valueOf(-100));
        //int i=10/0; //出现异常事务要回滚
        accountServiceDao.AddMoney(2, BigDecimal.valueOf(100));
        return "print over";
    }
}
