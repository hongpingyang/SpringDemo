package com.hong.py.springSourceCode.SelfTransactioManage.selfAdvisor;

import com.hong.py.springSourceCode.SelfTransactioManage.advice.SelfAdvice;

public interface SelfAdvisor {

    SelfAdvice EMPTY_ADVICE = new SelfAdvice() {};

    SelfAdvice getAdvice();
}
