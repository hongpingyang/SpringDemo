package com.hong.py.serviceImpl;

public class TestMethodInterceptor /*implements ITestMethodInterceptor*/  {

    private String testVal="";

    public void doSomeThing() {
        System.out.println("这是个被拦截的方法");
    }

    public  void SetValue(String testVal) {
        this.testVal=testVal;
    }

    /**
     * final
     * @return
     */
    public final String getVal() {
        return testVal;
    }
}
