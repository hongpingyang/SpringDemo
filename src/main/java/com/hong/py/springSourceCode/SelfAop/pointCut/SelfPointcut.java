package com.hong.py.springSourceCode.SelfAop.pointCut;

import com.hong.py.springSourceCode.common.SelfMethodMatcher;

public interface SelfPointcut {

    SelfMethodMatcher getMethodMatcher();
}
