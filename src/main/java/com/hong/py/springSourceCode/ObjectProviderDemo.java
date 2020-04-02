package com.hong.py.springSourceCode;

import com.hong.py.serviceImpl.ChildBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/2 9:55
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/2 9:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/

@Component
public class ObjectProviderDemo {

    //上面是最常见的注入方式，如果忘记写@Autowired注解，那么在启动的时候就会抛出异常。
    //但在spring 4.3之后，引入了一个新特性：当构造方法的参数为单个构造参数时，
    // 可以不使用@Autowired进行注解。这样的好处很显然，当容器中不存在FooRepository或存在多个时，可以从容处理。
    // 但坏处也很明显，如果FooRepository不能为null，
    // 则可能将异常从启动阶段转移到业务运行阶段。
    //@Autowired
    private final ChildBean childBean;

    public ObjectProviderDemo(ObjectProvider<ChildBean>childBean) {
        this.childBean = childBean.getIfUnique();
    }

    /**
     * 打印bean
     * @return
     */
    public String printChildBean() {
        System.out.println(childBean.toString());
        return this.childBean.toString();
    }

}
