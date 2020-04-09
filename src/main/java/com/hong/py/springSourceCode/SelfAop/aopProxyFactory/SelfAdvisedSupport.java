package com.hong.py.springSourceCode.SelfAop.aopProxyFactory;

import com.hong.py.springSourceCode.SelfAop.advice.SelfAdvice;
import com.hong.py.springSourceCode.SelfAop.joinPoint.SelfMethodInterceptor;
import com.hong.py.springSourceCode.SelfAop.pointCut.SelfPointcut;
import com.hong.py.springSourceCode.common.SelfMethodMatcher;
import com.hong.py.springSourceCode.common.SelfAdvisor;
import com.hong.py.springSourceCode.SelfAop.selfAdvisor.SelfPointCutAdvisor;
import org.springframework.core.OrderComparator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
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

    /**
     * 获取拦截器
     * @param method
     * @param targetClass
     * @return
     */
    public List<Object> getChainInterceptors(Method method, Class<?> targetClass) {
        List<Object> interceptorList = new ArrayList<>(advisors.size());

        if(!targetClass.equals(target.getClass()))
            return interceptorList;

        for (SelfAdvisor advisor : advisors) {
            if (advisor instanceof SelfPointcut) {
                SelfPointcut pointCutAdvisor = (SelfPointcut) advisor;
                SelfMethodMatcher methodMatcher = pointCutAdvisor.getMethodMatcher();
                boolean matches = methodMatcher.matches(method, targetClass);
                if (matches) {
                    //interceptorList.add(advisor);
                    SelfAdvice advice = advisor.getAdvice();
                    if (advice instanceof SelfMethodInterceptor) {
                        interceptorList.add(advice);
                    }
                }
            }
        }

        //排序
        Comparator<Object> comparatorToUse = OrderComparator.INSTANCE;
        interceptorList.sort(comparatorToUse);

        return interceptorList;
    }
}
