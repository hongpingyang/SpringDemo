package com.hong.py.springSourceCode.SelfTransactioManage.aopProxyFactory;

import com.hong.py.springSourceCode.SelfTransactioManage.selfAdvisor.SelfAdvisor;

import java.util.ArrayList;
import java.util.List;

public class SelfAdvisedSupport {

    private String beanName;

    private Object target;

    private List<SelfAdvisor> advisors = new ArrayList<>();

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public List<SelfAdvisor> getAdvisors() {
        return advisors;
    }

    public void setAdvisors(List<SelfAdvisor> advisors) {
        this.advisors = advisors;
    }
}
