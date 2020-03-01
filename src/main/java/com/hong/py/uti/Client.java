package com.hong.py.uti;

import com.hong.py.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * ClassPathXmlApplicationContext:加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话,加载不了
 * FileSystemXmLApplicationContext:加载磁盘上的配置文件，必须有访问权限
 * AnnotationConfigApplicationContext:用于读取注解的配置
 *
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext cs = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IAccountService accountservice = (IAccountService)cs.getBean("accountservice");
        accountservice.AddAccount();

        IAccountService accountservicefactory1 = (IAccountService)cs.getBean("accountservicefactory1");
        accountservicefactory1.AddAccount();

        IAccountService accountservicefactory2 = (IAccountService)cs.getBean("accountservicefactory2");
        accountservicefactory2.AddAccount();

        IAccountService accountservice2 = (IAccountService)cs.getBean("accountservice2");
        accountservice2.AddAccount();

        IAccountService accountservice3 = (IAccountService)cs.getBean("accountservice3");
        accountservice3.AddAccount();
    }
}
