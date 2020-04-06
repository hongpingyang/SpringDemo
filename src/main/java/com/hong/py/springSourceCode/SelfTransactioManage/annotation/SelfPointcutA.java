package com.hong.py.springSourceCode.SelfTransactioManage.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SelfPointcutA {

    /**
     * @return the pointcut expression
     * We allow "" as default for abstract pointcut
     */
    String value() default "";

    /**
     * When compiling without debug info, or when interpreting pointcuts at runtime,
     * the names of any arguments used in the pointcut are not available.
     * Under these circumstances only, it is necessary to provide the arg names in
     * the annotation - these MUST duplicate the names used in the annotated method.
     * Format is a simple comma-separated list.
     *
     * @return argNames the argument names (should match those in the annotated method)
     */
    String argNames() default "";
}
