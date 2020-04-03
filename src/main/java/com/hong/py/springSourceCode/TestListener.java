package com.hong.py.springSourceCode;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TestListener implements ApplicationListener {

    public TestListener() {
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof TestEvent) {
            System.out.println("TestListener received");
            TestEvent testEvent=(TestEvent) event;
            testEvent.print();
            System.out.println("=======================");
        } else if (event instanceof ContextRefreshedEvent) {
            System.out.println("容器refreshed");
        }
    }
}
