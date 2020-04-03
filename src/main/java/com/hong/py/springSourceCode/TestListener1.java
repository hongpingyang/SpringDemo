package com.hong.py.springSourceCode;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/2 16:55
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/2 16:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
@Component
public class TestListener1 implements ApplicationListener, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public TestListener1() {

    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof TestEvent) {
            System.out.println("TestListener1 received");
            TestEvent testEvent=(TestEvent) event;
            testEvent.print();
            System.out.println("=======================");
        } else if (event instanceof ContextRefreshedEvent) {
            System.out.println("容器refreshed");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       this.applicationContext=applicationContext;
    }

    /**
     * 发布消息
     */
    public void doSomeEvent() {
        TestEvent testEvent = new TestEvent("hello", "this is TestListener1's msg");
        this.applicationContext.publishEvent(testEvent); //如果存在父容器也会调用
    }
}
