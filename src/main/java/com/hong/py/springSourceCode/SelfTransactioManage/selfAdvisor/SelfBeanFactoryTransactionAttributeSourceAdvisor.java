package com.hong.py.springSourceCode.SelfTransactioManage.selfAdvisor;

import com.hong.py.springSourceCode.SelfAop.advice.SelfAdvice;
import com.hong.py.springSourceCode.common.SelfMethodMatcher;
import com.hong.py.springSourceCode.SelfAop.pointCut.SelfPointcut;
import com.hong.py.springSourceCode.common.SelfAdvisor;
import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionAttributeSource;
import com.hong.py.springSourceCode.SelfTransactioManage.interceptor.SelfTransactionInterceptor;

public class SelfBeanFactoryTransactionAttributeSourceAdvisor implements  SelfAdvisor, SelfPointcut {

    private SelfTransactionAttributeSource selfTransactionAttributeSource;

    private SelfAdvice advice;

    private TransactionMethodMatcher methodMatcher = new TransactionMethodMatcher();

    public void setTransactionAttributeSource(SelfTransactionAttributeSource selfTransactionAttributeSource) {
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

        return methodMatcher;
    }
}
