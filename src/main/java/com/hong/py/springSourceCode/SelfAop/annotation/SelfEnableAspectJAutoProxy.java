package com.hong.py.springSourceCode.SelfAop.annotation;


import com.hong.py.springSourceCode.SelfAop.configuration.SelfAspectJAutoProxyRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SelfAspectJAutoProxyRegistrar.class)
public @interface SelfEnableAspectJAutoProxy {




}
