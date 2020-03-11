package com.hong.py.springSourceCode;

import com.hong.py.serviceImpl.ChildBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class MyBeanFactoryAware implements BeanFactoryAware {

    private  BeanFactory  beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void AddBean() {
        DefaultListableBeanFactory factory=(DefaultListableBeanFactory)beanFactory;
        MutablePropertyValues values=new MutablePropertyValues();
        values.add("name","my ChildBeandog haha ");
        values.add("age","11");
        values.add("height","180");
        BeanDefinition definition=new RootBeanDefinition(ChildBean.class,null,values);
        factory.registerBeanDefinition("ChildBeandog",definition);
        //ChildBean dog=(ChildBean)factory.getBean("ChildBeandog");
        //System.out.print(dog.getName());
    }
}
