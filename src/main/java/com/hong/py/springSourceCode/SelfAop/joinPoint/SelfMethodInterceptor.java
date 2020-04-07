package com.hong.py.springSourceCode.SelfAop.joinPoint;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.SelfAop.joinPoint
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/7 9:59
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/7 9:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
public interface SelfMethodInterceptor {

    Object invoke(SelfMethodInvocation invocation) throws Throwable;
}
