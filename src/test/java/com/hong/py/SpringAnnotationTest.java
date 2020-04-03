package com.hong.py;

import com.hong.py.springSourceCode.ObjectProviderDemo;
import com.hong.py.springSourceCode.TestListener1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/2 10:02
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/2 10:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.hong.py.springSourceCode.MainConfig.class})
public class SpringAnnotationTest {

    @Autowired
    private ObjectProviderDemo objectProviderDemo;

    @Autowired
    private TestListener1 testListener1;

    @Test
    public void testObjectProvider() {
        objectProviderDemo.printChildBean();
    }

    @Test
    public void testApplicationListener() {
        testListener1.doSomeEvent();
    }

}
