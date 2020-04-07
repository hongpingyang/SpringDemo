package com.hong.py.springSourceCode.SelfAop.selfAdvisor;

import  com.hong.py.springSourceCode.SelfAop.advice.SelfAdvice;

public interface SelfAdvisor {

    SelfAdvice EMPTY_ADVICE = new SelfAdvice() {};

    SelfAdvice getAdvice();
}
