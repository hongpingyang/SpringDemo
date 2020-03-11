package com.hong.py;


import com.hong.py.serviceImpl.*;
import com.hong.py.springSourceCode.MyBeanFactoryAware;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

    @Test
    public void testSampleLoad() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        /*AccountServiceImpl accountservice = (AccountServiceImpl) beanFactory.getBean("accountservice");
        System.out.println(accountservice.toString());*/
        /*ChildBean testChild = (ChildBean)beanFactory.getBean("testChild");
        System.out.println(testChild.toString());*/

        AutoWireByName autoWireByName = (AutoWireByName)beanFactory.getBean("autoWireByNamenew");
        autoWireByName.testPrintName();
        AutoWireByConstructor autoWireByConstructor = (AutoWireByConstructor)beanFactory.getBean("autoWireByConstructor");
        autoWireByConstructor.testPrintName();

        MyBeanFactoryAware myBeanFactoryAware = (MyBeanFactoryAware) beanFactory.getBean("myBeanFactoryAware");
        myBeanFactoryAware.AddBean();
        ChildBean testChilddog = (ChildBean)beanFactory.getBean("ChildBeandog");
        System.out.println(testChilddog.toString());

        IdRefDemo idRefDemo = (IdRefDemo) beanFactory.getBean("idRefDemo");
        System.out.println(idRefDemo.toString());
        IdRefDemo idRefDemo2 = (IdRefDemo) beanFactory.getBean("idRefDemo2");
        System.out.println(idRefDemo2.toString());
        IdRefDemo idRefDemo3 = (IdRefDemo) beanFactory.getBean("idRefDemo3");
        System.out.println(idRefDemo3.toString());
    }
}
