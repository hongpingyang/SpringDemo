package com.hong.py.springSourceCode.SelfTransactioManage.core;

import com.hong.py.springSourceCode.SelfTransactioManage.interceptor.SelfTransactionAttribute;

import java.lang.reflect.Method;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.SelfTransactioManage.core
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/8 17:47
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/8 17:47
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
public interface SelfTransactionAttributeSource {

    SelfTransactionAttribute getTransactionAttribute(Method method, Class<?> targetClass);
}
