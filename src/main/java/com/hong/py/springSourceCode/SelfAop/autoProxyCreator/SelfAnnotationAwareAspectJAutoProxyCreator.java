package com.hong.py.springSourceCode.SelfAop.autoProxyCreator;

import com.hong.py.springSourceCode.SelfAop.annotation.SelfAspect;
import com.hong.py.springSourceCode.SelfAop.aopProxyFactory.SelfAopProxyFactory;
import com.hong.py.springSourceCode.SelfAop.core.SelfAspectJAdvisorsBuilder;
import com.hong.py.springSourceCode.SelfAop.pointCut.SelfMethodMatcher;
import com.hong.py.springSourceCode.SelfAop.selfAdvisor.SelfAdvisor;
import com.hong.py.springSourceCode.SelfAop.selfAdvisor.SelfPointCutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class SelfAnnotationAwareAspectJAutoProxyCreator  implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    private SelfAspectJAdvisorsBuilder aspectJAdvisorsBuilder;


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
       this.beanFactory= (ConfigurableListableBeanFactory) beanFactory;

        aspectJAdvisorsBuilder=new SelfAspectJAdvisorsBuilder();
        aspectJAdvisorsBuilder.setBeanFactory(this.beanFactory);

    }

    /**
     * 处理切面
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        aspectJAdvisorsBuilder.GetAspectJAdvisors();

        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * 返回代理类
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        //需要过滤掉切面类
        if (bean.getClass().getAnnotation(SelfAspect.class) != null) {
            return bean;
        }
        List<SelfAdvisor> advicesAndAdvisorsForBean = getAdvicesAndAdvisorsForBean(bean.getClass());
        //生成代理
        if (advicesAndAdvisorsForBean != null && advicesAndAdvisorsForBean.size() > 0) {
            return CreateProxy(bean,beanName,advicesAndAdvisorsForBean);
        }
        return bean;
    }


    /**
     * 找到合适的增强器
     * @param beanClass
     * @return
     */
    protected List<SelfAdvisor> getAdvicesAndAdvisorsForBean(Class<?> beanClass) {

        List<SelfAdvisor> candidateAdvisors = this.aspectJAdvisorsBuilder.GetAspectJAdvisors();

        if (candidateAdvisors.isEmpty()) {
            return null;
        }

        List<SelfAdvisor> eligibleAdvisors = findAdvisorsThatCanApply(candidateAdvisors, beanClass);

        return eligibleAdvisors;
    }


   private List<SelfAdvisor> findAdvisorsThatCanApply(List<SelfAdvisor> candidateAdvisors, Class<?> clazz) {
       if (candidateAdvisors.isEmpty()) {
           return candidateAdvisors;
       }
       List<SelfAdvisor> eligibleAdvisors = new ArrayList<>();
       for (SelfAdvisor candidate : candidateAdvisors) {
           if (canApply(candidate, clazz)) {
               eligibleAdvisors.add(candidate);
           }
       }
       return eligibleAdvisors;
   }

    private static boolean canApply(SelfAdvisor advisor, Class<?> targetClass) {
        if (advisor instanceof SelfPointCutAdvisor) {
            SelfPointCutAdvisor pca = (SelfPointCutAdvisor) advisor;
            return canApply(pca.getMethodMatcher(), targetClass);
        }
        else {
            // It doesn't have a pointcut so we assume it applies.
            return true;
        }
    }

    public static boolean canApply(SelfMethodMatcher methodMatcher, Class<?> targetClass) {

        Set<Class<?>> classes = new LinkedHashSet<>();

        if (!Proxy.isProxyClass(targetClass)) {
            classes.add(ClassUtils.getUserClass(targetClass));
        }
        //获取所有的接口
        classes.addAll(ClassUtils.getAllInterfacesForClassAsSet(targetClass));

        for (Class<?> clazz : classes) {
            Method[] methods = ReflectionUtils.getAllDeclaredMethods(clazz);
            for (Method method : methods) {
                   if(methodMatcher.matches(method, targetClass)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Object CreateProxy(Object bean,String beanName,List<SelfAdvisor> advisors) {
        SelfAopProxyFactory selfAopProxyFactory = new SelfAopProxyFactory();
        selfAopProxyFactory.setTarget(bean);
        selfAopProxyFactory.setAdvisors(advisors);
        selfAopProxyFactory.setBeanName(beanName);
        return selfAopProxyFactory.getProxy();
    }

}
