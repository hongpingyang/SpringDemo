package com.hong.py.springSourceCode.SelfTransactioManage.pointCut;

import java.lang.reflect.Method;

/**
 * 方法匹配器
 */
public interface SelfMethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
