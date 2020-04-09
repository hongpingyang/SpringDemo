package com.hong.py.springSourceCode.SelfTransactioManage.annotation;

import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionDefinition;
import com.hong.py.springSourceCode.SelfTransactioManage.selfenum.SelfIsolation;
import com.hong.py.springSourceCode.SelfTransactioManage.selfenum.SelfPropagation;

import java.lang.annotation.*;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.SelfTransactioManage.annotation
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/9 10:06
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/9 10:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SelfTransactional {

    String value() default "";

    SelfPropagation selfPropagation() default SelfPropagation.REQUIRED;

    SelfIsolation selfIsolation() default SelfIsolation.DEFAULT;

    int timeOut() default SelfTransactionDefinition.TIMEOUT_DEFAULT;

    boolean readOnly() default SelfTransactionDefinition.READ_ONLY;
}
