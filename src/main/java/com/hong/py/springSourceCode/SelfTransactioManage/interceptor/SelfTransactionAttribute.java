package com.hong.py.springSourceCode.SelfTransactioManage.interceptor;

import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionDefinition;

/**
 * 事务要素
 */
public class SelfTransactionAttribute implements SelfTransactionDefinition {


    int propagationBehavior=0;

    int isolationLevel=0;

    int timeout=0;

    boolean readOnly=false;

    String name=null;

    @Override
    public int getPropagationBehavior() {
        return this.propagationBehavior;
    }

    @Override
    public int getIsolationLevel() {
        return this.isolationLevel;
    }

    @Override
    public int getTimeout() {
        return this.timeout;
    }

    @Override
    public boolean isReadOnly() {
        return this.readOnly;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setPropagationBehavior(int propagationBehavior) {
        this.propagationBehavior = propagationBehavior;
    }

    public void setIsolationLevel(int isolationLevel) {
        this.isolationLevel = isolationLevel;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 异常回滚点
     * @param ex
     * @return
     */
    public boolean rollbackOn(Throwable ex) {
        return (ex instanceof RuntimeException || ex instanceof Error);
    }
}
