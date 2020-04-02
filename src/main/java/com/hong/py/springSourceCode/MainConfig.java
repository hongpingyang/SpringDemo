package com.hong.py.springSourceCode;

import com.hong.py.serviceImpl.ChildBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/2 9:58
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/2 9:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
@Configuration
@ComponentScan(value ={"com.hong.py.springSourceCode"} )
//会提示不能重复
@Import(value = com.hong.py.springSourceCode.MyImportSelector.class )
//@Import(value = com.hong.py.springSourceCode.MyImportBeanDefinitionRegistrar.class)
public class MainConfig {

    /*@Bean
    public ChildBean childBean() {
        ChildBean childBean = new ChildBean();
        childBean.setAge(18);
        childBean.setName("洪大洋");
        childBean.setHeight(180);
        return childBean;
    }*/
}
