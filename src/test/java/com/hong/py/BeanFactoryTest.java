package com.hong.py;


import com.hong.py.serviceImpl.AccountServiceImpl;
import com.hong.py.serviceImpl.ChildBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

    @Test
    public void testSampleLoad() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
       /* AccountServiceImpl accountservice = (AccountServiceImpl) beanFactory.getBean("accountservice");
        System.out.println(accountservice.toString());*/
        ChildBean testChild = (ChildBean)beanFactory.getBean("testChild");
        System.out.println(testChild.toString());
    }
}
