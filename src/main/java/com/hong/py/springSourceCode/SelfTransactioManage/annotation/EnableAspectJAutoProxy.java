package com.hong.py.springSourceCode.SelfTransactioManage.annotation;


import com.hong.py.springSourceCode.SelfTransactioManage.configuration.SelfAspectJAutoProxyRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SelfAspectJAutoProxyRegistrar.class)
public @interface EnableAspectJAutoProxy {




}
