package com.hong.py;


import com.hong.py.factory.AccountFactory;
import com.hong.py.factory.MyFactoryBean;
import com.hong.py.serviceImpl.*;
import com.hong.py.springSourceCode.MyBeanFactoryAware;
import com.hong.py.springSourceCode.MyClassPathXmlApplicationContext;
import com.hong.py.springSourceCode.MyInitializingBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringValueResolver;

public class BeanFactoryTest {

    @Test
    public void testSampleLoad() {
        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        /*AccountServiceImpl accountservice = (AccountServiceImpl) beanFactory.getBean("accountservice");
        System.out.println(accountservice.toString());*/
        /*ChildBean testChild = (ChildBean)beanFactory.getBean("testChild");
        System.out.println(testChild.toString());

        AutoWireByName autoWireByName = (AutoWireByName)beanFactory.getBean("autoWireByNamenew");
        autoWireByName.testPrintName();
        AutoWireByConstructor autoWireByConstructor = (AutoWireByConstructor)beanFactory.getBean("autoWireByConstructor");
        autoWireByConstructor.testPrintName();

        MyBeanFactoryAware myBeanFactoryAware = (MyBeanFactoryAware) beanFactory.getBean("myBeanFactoryAware");
        myBeanFactoryAware.AddBean();
        ChildBean testChilddog = (ChildBean)beanFactory.getBean("ChildBeandog");
        System.out.println(testChilddog.toString());*/

        /*IdRefDemo idRefDemo = (IdRefDemo) beanFactory.getBean("idRefDemo");
        System.out.println(idRefDemo.toString());
        IdRefDemo idRefDemo2 = (IdRefDemo) beanFactory.getBean("idRefDemo2");
        System.out.println(idRefDemo2.toString());
        IdRefDemo idRefDemo3 = (IdRefDemo) beanFactory.getBean("idRefDemo3");
        System.out.println(idRefDemo3.toString());
        */

        //返回工厂的getObject返回的实例
        /*ChildBean childBean = (ChildBean) beanFactory.getBean("myFactoryBean");
        System.out.println(childBean.toString());
        //返回工厂bean的实例
        MyFactoryBean myFactoryBean = (MyFactoryBean) beanFactory.getBean("&myFactoryBean");
        System.out.println(myFactoryBean.toString());*/

        //返回工厂bean的实例
        /*AccountServiceImpl accountServiceImpl = (AccountServiceImpl) beanFactory.getBean("accountservicefactory1");
        System.out.println(accountServiceImpl.toString());*/

        /*ApplicationContext parentbeanFactory = new ClassPathXmlApplicationContext("propertyEditor.xml");
        PropertyEditorDemo propertyEditorDemo = (PropertyEditorDemo) parentbeanFactory.getBean("propertyEditorDemo");
        System.out.println(propertyEditorDemo.toString());*/

        /*BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        MyBeanFactoryAware myBeanFactoryAware = (MyBeanFactoryAware) beanFactory.getBean("myBeanFactoryAware");
        myBeanFactoryAware.AddBean();*/

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        MyInitializingBean myInitializingBean = (MyInitializingBean) beanFactory.getBean("myInitializingBean");
        myInitializingBean.printStr();
    }

    @Test
    public void parentBeanFactory() {
        /*ApplicationContext parentbeanFactory = new ClassPathXmlApplicationContext("parent.xml");
        ApplicationContext sonbeanFactory = new ClassPathXmlApplicationContext(new String[]{"child.xml"}, parentbeanFactory);
        System.out.println(sonbeanFactory.getBean("child"));
        System.out.println(sonbeanFactory.getBean("parent"));
        //会抛出异常
        //org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'child' available
        System.out.println(parentbeanFactory.getBean("child"));
        System.out.println(parentbeanFactory.getBean("parent"));

        System.out.println(sonbeanFactory.containsBean("child"));  //子容器中可以获取Bean:child
        System.out.println(parentbeanFactory.containsBean("child")); //父容器中不可以获取Bean:child
        System.out.println(sonbeanFactory.containsBean("parent")); //子容器中可以获取Bean:parent
        System.out.println(parentbeanFactory.containsBean("parent")); //父容器可以获取Bean:parent

        ApplicationContext parent2 = (ApplicationContext) sonbeanFactory.getParentBeanFactory();  //获取当前接口的父容器
        System.out.println(parentbeanFactory == parent2);
        System.out.println(sonbeanFactory.containsLocalBean("child"));  //当前子容器本地是包含child
        System.out.println(parentbeanFactory.containsLocalBean("child")); //当前父容器本地不包含child
        System.out.println(sonbeanFactory.containsLocalBean("parent")); //当前子容器本地不包含child
        System.out.println(parentbeanFactory.containsLocalBean("parent")); //当前父容器本地包含parent*/
    }

    @Test
    public void convertorTest() {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("convertor.xml");
        PropertyEditorDemo propertyEditorDemo = (PropertyEditorDemo)beanFactory.getBean("propertyEditorDemo");
        System.out.println(propertyEditorDemo.toString());

    }

    @Test
    public void myApplicationContext() {
        ApplicationContext  myClassPathXmlApplicationContext= new MyClassPathXmlApplicationContext("child.xml");
        ChildBean child = (ChildBean)myClassPathXmlApplicationContext.getBean("child");
        System.out.println(child);
    }

    @Test
    public void myPropertyEditor() {
        ApplicationContext parentbeanFactory = new ClassPathXmlApplicationContext("propertyEditor.xml");
        PropertyEditorDemo propertyEditorDemo = (PropertyEditorDemo) parentbeanFactory.getBean("propertyEditorDemo");
        System.out.println(propertyEditorDemo.toString());


    }
}
