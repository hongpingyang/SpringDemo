package com.hong.py.springSourceCode.SelfTransactioManage.selfAdvisor;

import com.hong.py.springSourceCode.SelfTransactioManage.advice.SelfAdvice;
import com.hong.py.springSourceCode.SelfTransactioManage.pointCut.AspectJMethodMatcher;
import com.hong.py.springSourceCode.SelfTransactioManage.pointCut.SelfMethodMatcher;
import com.hong.py.springSourceCode.SelfTransactioManage.pointCut.SelfPointcut;

import java.lang.reflect.Method;

public class SelfPointCutAdvisor implements SelfAdvisor, SelfPointcut {

    //通知
    private SelfAdvice advice;
    //方法
    private Method method;
    //切点表达式
    private String expression;

    public SelfPointCutAdvisor(SelfAdvice advice, Method method,String expression) {
        this.advice = advice;
        this.method = method;
        this.expression = expression;
    }


    @Override
    public SelfAdvice getAdvice() {
        return advice;
    }


    @Override
    public SelfMethodMatcher getMethodMatcher() {
        return new AspectJMethodMatcher(this.expression);
    }




}
