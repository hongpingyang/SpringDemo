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

        SelfTransactionAttribute selfAttribute = selfTransactionAnnotationParser.getSelfTransactionAttribute(method, targetClass);

        if (selfAttribute != null) {
            return true;
        }
        return false;
    }
}
