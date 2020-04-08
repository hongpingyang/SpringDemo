package com.hong.py.springSourceCode.SelfTransactioManage.autoProxy;

import com.hong.py.springSourceCode.SelfAop.aopProxyFactory.SelfAopProxyFactory;
import com.hong.py.springSourceCode.SelfAop.pointCut.SelfMethodMatcher;
import com.hong.py.springSourceCode.SelfAop.selfAdvisor.SelfAdvisor;
import com.hong.py.springSourceCode.SelfAop.selfAdvisor.SelfPointCutAdvisor;
import com.hong.py.springSourceCode.SelfTransactioManage.core.TransactionAdvisorsBuilder;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJPointcutAdvisor;
import org.springframework.aop.framework.AopInfrastructureBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SelfInfrastructureAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    private TransactionAdvisorsBuilder transactionAdvisorsBuilder;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
         this.beanFactory=(ConfigurableListableBeanFactory)beanFactory;

         transactionAdvisorsBuilder = new TransactionAdvisorsBuilder();
         transactionAdvisorsBuilder.setBeanFactory(this.beanFactory);
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

        List<SelfAdvisor> candidateAdvisors = this.transactionAdvisorsBuilder.GetAspectJAdvisors();

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
