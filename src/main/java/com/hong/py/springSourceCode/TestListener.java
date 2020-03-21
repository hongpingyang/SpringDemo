package com.hong.py.springSourceCode;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class TestListener implements ApplicationListener {

    public TestListener() {
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof TestEvent) {
            TestEvent testEvent=(TestEvent) event;
            testEvent.print();
        } else if (event instanceof ContextRefreshedEvent) {
            System.out.println("容器refreshed");
        }
    }
}
