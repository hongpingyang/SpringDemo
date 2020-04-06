package com.hong.py.springSourceCode.SelfTransactioManage.aopProxyFactory;


public class SelfAopProxyFactory extends SelfAdvisedSupport implements AopProxyFactory {

    //默认使用JDk
    public SelfAopProxy createAopProxy(){
        return new JdkDynamicAopProxy(this);
    }


    @Override
    public Object getProxy() {
        return createAopProxy().getProxy();
    }
}
