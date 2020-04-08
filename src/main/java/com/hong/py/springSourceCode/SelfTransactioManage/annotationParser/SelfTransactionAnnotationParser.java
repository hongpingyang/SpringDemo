package com.hong.py.springSourceCode.SelfTransactioManage.annotationParser;

import com.hong.py.springSourceCode.SelfTransactioManage.interceptor.SelfTransactionAttribute;
import com.hong.py.springSourceCode.SelfTransactioManage.selfenum.SelfIsolation;
import com.hong.py.springSourceCode.SelfTransactioManage.selfenum.SelfPropagation;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.AnnotatedElement;

public class SelfTransactionAnnotationParser {

    public SelfTransactionAttribute parseTransactionAnnotation(AnnotatedElement element) {
        AnnotationAttributes attributes = AnnotatedElementUtils.findMergedAnnotationAttributes(
                element, Transactional.class, false, false);
        if (attributes != null) {
            return parseTransactionAnnotation(attributes);
        }
        else {
            return null;
        }
    }

    protected SelfTransactionAttribute parseTransactionAnnotation(AnnotationAttributes attributes) {

        SelfTransactionAttribute selfTransactionAttribute = new SelfTransactionAttribute();

        SelfPropagation propagation = attributes.getEnum("propagation");
        selfTransactionAttribute.setPropagationBehavior(propagation.value());
        SelfIsolation isolation = attributes.getEnum("isolation");
        selfTransactionAttribute.setIsolationLevel(isolation.value());

        selfTransactionAttribute.setTimeout(attributes.getNumber("timeout").intValue());
        selfTransactionAttribute.setReadOnly(attributes.getBoolean("readOnly"));


        return selfTransactionAttribute;
    }


}
