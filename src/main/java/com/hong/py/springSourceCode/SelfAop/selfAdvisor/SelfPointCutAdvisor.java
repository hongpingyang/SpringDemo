package com.hong.py.springSourceCode.SelfAop.selfAdvisor;

import com.hong.py.springSourceCode.SelfAop.advice.SelfAdvice;
import com.hong.py.springSourceCode.SelfAop.pointCut.AspectJMethodMatcher;
import com.hong.py.springSourceCode.SelfAop.pointCut.SelfMethodMatcher;
import com.hong.py.springSourceCode.SelfAop.pointCut.SelfPointcut;

import java.lang.reflect.Method;

public class SelfPointCutAdvisor implements SelfAdvisor, SelfPointcut {

    //通知
    private SelfAdvice advice;
    //目标类
    private Class<?> candidateAspectClass;
    //方法
    private Method method;
    //切点表达式
    private String expression;

    public SelfPointCutAdvisor(Class<?> candidateAspectClass,SelfAdvice advice, Method method,String expression) {
        this.candidateAspectClass=candidateAspectClass;
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
        return new AspectJMethodMatcher(this.candidateAspectClass,this.expression);
    }




}
