package com.hong.py.springSourceCode.SelfTransactioManage.selfAdvisor;

import com.hong.py.springSourceCode.SelfAop.advice.SelfAdvice;
import com.hong.py.springSourceCode.SelfAop.pointCut.SelfMethodMatcher;
import com.hong.py.springSourceCode.SelfAop.pointCut.SelfPointcut;
import com.hong.py.springSourceCode.SelfAop.selfAdvisor.SelfAdvisor;
import com.hong.py.springSourceCode.SelfAop.selfAdvisor.SelfPointCutAdvisor;
import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionAttributeSource;
import com.hong.py.springSourceCode.SelfTransactioManage.interceptor.SelfTransactionInterceptor;

public class SelfBeanFactoryTransactionAttributeSourceAdvisor implements  SelfAdvisor, SelfPointcut {

    private SelfTransactionAttributeSource selfTransactionAttributeSource;

    private SelfAdvice advice;

    public void setTransactionAttributeSource(SelfTransactionAttributeSource transactionAttributeSource) {
       this.selfTransactionAttributeSource=selfTransactionAttributeSource;
    }

    public void setAdvice(SelfTransactionInterceptor transactionInterceptor) {
        this.advice=transactionInterceptor;
    }

    @Override
    public SelfAdvice getAdvice() {
        return advice;
    }

    @Override
    public SelfMethodMatcher getMethodMatcher() {


        return null;
    }
}
