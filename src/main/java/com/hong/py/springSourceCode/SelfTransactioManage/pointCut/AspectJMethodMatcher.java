package com.hong.py.springSourceCode.SelfTransactioManage.pointCut;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.ShadowMatch;

import java.lang.reflect.Method;

public class AspectJMethodMatcher implements SelfMethodMatcher {


    private String expression;

    private PointcutExpression pointcutExpression;

    public AspectJMethodMatcher(String expression) {
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
