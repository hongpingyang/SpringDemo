package com.hong.py.springSourceCode.test;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.SelfAop.test
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/7 11:28
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/7 11:28
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
public class SelfAspectPrint implements AspectPrint {

    @Override
    public String aspectPrint() {
        System.out.println("this is a printing");
        return "print over";
    }

    @Override
    public String aspectPrint1() {
        System.out.println("this is a printingfor1");
        return "print1 over";
    }
}
