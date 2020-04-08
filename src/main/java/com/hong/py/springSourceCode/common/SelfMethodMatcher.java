package com.hong.py.springSourceCode.common;

import java.lang.reflect.Method;

/**
 * 方法匹配器
 */
public interface SelfMethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
