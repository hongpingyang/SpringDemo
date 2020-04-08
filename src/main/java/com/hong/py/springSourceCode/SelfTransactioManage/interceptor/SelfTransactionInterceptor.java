package com.hong.py.springSourceCode.SelfTransactioManage.interceptor;

import com.hong.py.springSourceCode.SelfAop.advice.SelfAdvice;
import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionAttributeSource;

public class SelfTransactionInterceptor implements SelfAdvice {

    private SelfTransactionAttributeSource selfTransactionAttributeSource;

    public void setTransactionAttributeSource(SelfTransactionAttributeSource transactionAttributeSource) {
        this.selfTransactionAttributeSource=selfTransactionAttributeSource;
    }
}
