package com.hong.py.springSourceCode;

import com.hong.py.serviceImpl.ChildBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Aware类接口的实现类是为了得到某些资源，例如BeanFactoryAware是为来获取BeanFactory
 * 例如ApplicationContextAware是为来获取ApplicationContext
 */
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
        System.out.println("成功向容器中添加ChildBeandog");

    }
}
