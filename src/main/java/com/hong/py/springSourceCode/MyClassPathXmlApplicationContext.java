package com.hong.py.springSourceCode;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自定义ApplicationContext的要求验证系统环境变量
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String pathXml) {
        super(pathXml);
    }

    @Override
    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("JAVA_HOME");
    }
}
