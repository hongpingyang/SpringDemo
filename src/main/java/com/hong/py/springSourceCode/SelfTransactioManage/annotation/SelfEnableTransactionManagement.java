package com.hong.py.springSourceCode.SelfTransactioManage.annotation;


import com.hong.py.springSourceCode.SelfTransactioManage.configuration.SelfTransactionManagementConfigurationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SelfTransactionManagementConfigurationSelector.class)
public @interface SelfEnableTransactionManagement {




}
