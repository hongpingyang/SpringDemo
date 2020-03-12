package com.hong.py.factory;

import com.hong.py.serviceImpl.ChildBean;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new ChildBean();
    }

    @Override
    public Class<?> getObjectType() {
        return ChildBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
