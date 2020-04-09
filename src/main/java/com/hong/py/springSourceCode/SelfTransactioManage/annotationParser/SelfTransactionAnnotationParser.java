package com.hong.py.springSourceCode.SelfTransactioManage.annotationParser;

import com.hong.py.springSourceCode.SelfTransactioManage.annotation.SelfTransactional;
import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionAttribute;
import com.hong.py.springSourceCode.SelfTransactioManage.selfenum.SelfIsolation;
import com.hong.py.springSourceCode.SelfTransactioManage.selfenum.SelfPropagation;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.util.ClassUtils;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class SelfTransactionAnnotationParser {

    /**
     * 获取事务要素
     * @return
     */
    public SelfTransactionAttribute getSelfTransactionAttribute(Method method, Class<?> targetClass) {

        if (method.getDeclaringClass() == Object.class) {
            return null;
        }
        // The method may be on an interface, but we need attributes from the target class.
        // If the target class is null, the method will be unchanged.
        Method specificMethod = AopUtils.getMostSpecificMethod(method, targetClass);

        // First try is the method in the target class.
        SelfTransactionAttribute txAttr = parseTransactionAnnotation(specificMethod);
        if (txAttr != null) {
            return txAttr;
        }

        // Second try is the transaction attribute on the target class.
        txAttr = parseTransactionAnnotation(specificMethod.getDeclaringClass());
        if (txAttr != null && ClassUtils.isUserLevelMethod(method)) {
            return txAttr;
        }

        if (specificMethod != method) {
            // Fallback is to look at the original method.
            txAttr = parseTransactionAnnotation(method);
            if (txAttr != null) {
                return txAttr;
            }
            // Last fallback is the class of the original method.
            txAttr = parseTransactionAnnotation(method.getDeclaringClass());
            if (txAttr != null && ClassUtils.isUserLevelMethod(method)) {
                return txAttr;
            }
        }

        return null;

    }


    public SelfTransactionAttribute parseTransactionAnnotation(AnnotatedElement element) {
        AnnotationAttributes attributes = AnnotatedElementUtils.findMergedAnnotationAttributes(
                element, SelfTransactional.class, false, false);
        if (attributes != null) {
            return parseTransactionAnnotation(attributes);
        }
        else {
            return null;
        }
    }

    protected SelfTransactionAttribute parseTransactionAnnotation(AnnotationAttributes attributes) {

        SelfTransactionAttribute selfTransactionAttribute = new SelfTransactionAttribute();

        SelfPropagation propagation = attributes.getEnum("selfPropagation");
        selfTransactionAttribute.setPropagationBehavior(propagation.value());
        SelfIsolation isolation = attributes.getEnum("selfIsolation");
        selfTransactionAttribute.setIsolationLevel(isolation.value());

        selfTransactionAttribute.setTimeout(attributes.getNumber("timeOut").intValue());
        selfTransactionAttribute.setReadOnly(attributes.getBoolean("readOnly"));

        return selfTransactionAttribute;
    }


}
