package com.hong.py.springSourceCode.SelfTransactioManage.core;

import com.hong.py.springSourceCode.SelfTransactioManage.advice.AspectJBeforeSelfAdvice;
import com.hong.py.springSourceCode.SelfTransactioManage.advice.SelfAdvice;
import com.hong.py.springSourceCode.SelfTransactioManage.annotation.*;
import com.hong.py.springSourceCode.SelfTransactioManage.selfAdvisor.SelfAdvisor;
import com.hong.py.springSourceCode.SelfTransactioManage.selfAdvisor.SelfPointCutAdvisor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class AspectAdvisorsFinder {

    private static final Class<?>[] ASPECTJ_ANNOTATION_CLASSES = new Class<?>[] {
            SelfAfter.class, SelfAfterThrowing.class, SelfAfterReturning.class, SelfBefore.class};

    private static ConfigurableListableBeanFactory beanFactory;

    public static void setBeanFactory(BeanFactory beanFactory) {
        beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    public static BeanFactory getBeanFactory() {
        return beanFactory;
    }

    //是否有Aspect注解
    public static boolean hasAspectAnnotation(Class<?> clazz) {
        return (AnnotationUtils.findAnnotation(clazz, SelfAspect.class) != null);
    }

    public static List<SelfAdvisor> getAdvisors(Class<?> clazz) {
        List<SelfAdvisor> advisors = new ArrayList<>();

        for (Method method : getAdvisorMethods(clazz)) {
                SelfAdvisor advisor = getAdvisor(method,clazz);
            if (advisor != null) {
                advisors.add(advisor);
            }
        }
        return advisors;
    }


    private static SelfAdvisor getAdvisor(Method method,Class<?> clazz) {
        SelfAdvice advice = getAdvice(method, clazz);
        SelfAdvisor advisor = new SelfPointCutAdvisor(advice, method,parsePointCutExp(clazz));
        return advisor;
    }

    private static SelfAdvice getAdvice(Method method,Class<?> clazz) {
        if (method.getAnnotation(SelfBefore.class) != null) {
            AspectJBeforeSelfAdvice aspectJBeforeSelfAdvice = new AspectJBeforeSelfAdvice(method, clazz, getBeanFactory());
            return aspectJBeforeSelfAdvice;
        }

        //其他的继续去写

        return null;
    }

    /**
     * 获取去掉SelfPointcut注解的方法
     * @param aspectClass
     * @return
     */
    private static List<Method> getAdvisorMethods(Class<?> aspectClass) {
        final List<Method> methods = new ArrayList<>();
        Method[] declaredMethods = aspectClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (AnnotationUtils.getAnnotation(method, SelfPointcutA.class) == null) {
                methods.add(method);
            }
        }
        return methods;
    }

    /**
     * 从给定注解中解析出表达式
     * @return AngleAdvice
     */
    private static String  parsePointCutExp(Class<?> clazz)  {
        Method []methods = clazz.getDeclaredMethods();
        for(Method method :methods) {
            SelfPointcutA selfPointCut = method.getAnnotation(SelfPointcutA.class);
            if(selfPointCut!=null) {
                return selfPointCut.value();
            }
        }
        throw new RuntimeException("SelfPointcutA切点表达式不存在");
    }

}
