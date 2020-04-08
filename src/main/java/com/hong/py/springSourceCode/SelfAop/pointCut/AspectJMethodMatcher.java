package com.hong.py.springSourceCode.SelfAop.pointCut;

import com.hong.py.springSourceCode.common.SelfMethodMatcher;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.ShadowMatch;

import java.lang.reflect.Method;

public class AspectJMethodMatcher implements SelfMethodMatcher {


    private Class<?> candidateAspectClass;

    private String expression;

    private PointcutExpression pointcutExpression;

    public AspectJMethodMatcher(Class<?> candidateAspectClass,String expression) {
        this.candidateAspectClass=candidateAspectClass;
        this.expression=expression;
        pointcutExpression=buildPointcutExpression();
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        ShadowMatch sm = pointcutExpression.matchesMethodExecution(method);
        return sm.alwaysMatches();
    }

    private PointcutExpression buildPointcutExpression() {
        PointcutParser parser = initializePointcutParser();
        return parser.parsePointcutExpression(this.expression);
    }

    private PointcutParser initializePointcutParser() {
        PointcutParser parser = PointcutParser
                .getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();
        return parser;
    }
}
