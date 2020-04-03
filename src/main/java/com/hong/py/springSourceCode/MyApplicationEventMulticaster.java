package com.hong.py.springSourceCode;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/3 9:16
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/3 9:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * 支持线程池异步发布
 **/
public class MyApplicationEventMulticaster extends SimpleApplicationEventMulticaster {

    public MyApplicationEventMulticaster() {

    }

    public MyApplicationEventMulticaster(BeanFactory beanFactory) {
        super(beanFactory);
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(1,5,10, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        setTaskExecutor(threadPoolExecutor);
    }
}
