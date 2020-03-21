package com.hong.py.springSourceCode;

import org.springframework.context.Lifecycle;

public class LifeCycleDemo implements Lifecycle {

    @Override
    public void start() {
        System.out.println("容器OnRefresh");
    }

    @Override
    public void stop() {
        System.out.println("容器stop");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
