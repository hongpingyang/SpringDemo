package com.hong.py.springSourceCode;

import org.springframework.beans.factory.InitializingBean;

/**
 * InitializingBean接口在initMethod之前执行
 */
public class MyInitializingBean implements InitializingBean {

    private  String testStr;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("this is afterPropertiesSet");
        this.testStr="afterPropertiesSet";
    }

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        System.out.println("this is propertySet");
        this.testStr = testStr;
    }

    public void printStr() {
        System.out.println(testStr);
    }

    public void initMethod() {
        System.out.println("this is initMethod");
        this.testStr="initMethod";
    }
}
