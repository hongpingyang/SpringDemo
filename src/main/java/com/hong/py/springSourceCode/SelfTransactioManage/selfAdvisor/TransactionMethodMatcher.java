package com.hong.py.springSourceCode.SelfTransactioManage.selfAdvisor;

import com.hong.py.springSourceCode.SelfTransactioManage.annotationParser.SelfTransactionAnnotationParser;
import com.hong.py.springSourceCode.SelfTransactioManage.interceptor.SelfTransactionAttribute;
import com.hong.py.springSourceCode.common.SelfMethodMatcher;
import org.springframework.aop.support.AopUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

public class TransactionMethodMatcher  implements SelfMethodMatcher {


    private SelfTransactionAnnotationParser selfTransactionAnnotationParser = new SelfTransactionAnnotationParser();


    @Override
    public boolean matches(Method method, Class<?> targetClass) {

        SelfTransactionAttribute selfAttribute = getSelfTransactionAttribute(method, targetClass);

        if (selfAttribute != null) {
            return true;
        }
        return false;
    }


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
        SelfTransactionAttribute txAttr = selfTransactionAnnotationParser.parseTransactionAnnotation(specificMethod);
        if (txAttr != null) {
            return txAttr;
        }

        // Second try is the transaction attribute on the target class.
        txAttr = selfTransactionAnnotationParser.parseTransactionAnnotation(specificMethod.getDeclaringClass());
        if (txAttr != null && ClassUtils.isUserLevelMethod(method)) {
            return txAttr;
        }

        if (specificMethod != method) {
            // Fallback is to look at the original method.
            txAttr = selfTransactionAnnotationParser.parseTransactionAnnotation(method);
            if (txAttr != null) {
                return txAttr;
            }
            // Last fallback is the class of the original method.
            txAttr = selfTransactionAnnotationParser.parseTransactionAnnotation(method.getDeclaringClass());
            if (txAttr != null && ClassUtils.isUserLevelMethod(method)) {
                return txAttr;
            }
        }

        return null;

    }
}
