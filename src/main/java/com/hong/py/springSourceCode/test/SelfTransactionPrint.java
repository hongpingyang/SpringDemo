package com.hong.py.springSourceCode.test;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.test
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/8 15:49
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/8 15:49
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class SelfTransactionPrint implements TransactionPrint {

    @Override
    public String aspectPrint() {
        System.out.println("this is a printing");
        return "print over";
    }
}
