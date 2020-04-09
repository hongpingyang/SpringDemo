package com.hong.py.springSourceCode.SelfTransactioManage.core;

import com.hong.py.springSourceCode.SelfTransactioManage.annotationParser.SelfTransactionAnnotationParser;

import java.lang.reflect.Method;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.SelfTransactioManage.core
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/9 15:13
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/9 15:13
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
public class SelfAnnotationTransactionAttributeSource implements SelfTransactionAttributeSource {

    private SelfTransactionAnnotationParser selfTransactionAnnotationParser = new SelfTransactionAnnotationParser();

    @Override
    public SelfTransactionAttribute getTransactionAttribute(Method method, Class<?> targetClass) {
        return selfTransactionAnnotationParser.getSelfTransactionAttribute(method, targetClass);
    }

}
