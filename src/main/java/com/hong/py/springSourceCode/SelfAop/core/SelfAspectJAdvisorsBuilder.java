package com.hong.py.springSourceCode.SelfAop.core;


import com.hong.py.springSourceCode.SelfAop.selfAdvisor.SelfAdvisor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SelfAspectJAdvisorsBuilder {

    private List<String> aspectJNames = new ArrayList<>();

    private final Map<String, List<SelfAdvisor>> advisorsCache = new ConcurrentHashMap<>();

    private ConfigurableListableBeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
        AspectAdvisorsFinder.setBeanFactory(beanFactory);
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }


    public List<SelfAdvisor> GetAspectJAdvisors() {
        List<SelfAdvisor> selfAdvisors = buildAspectJAdvisors();
        return selfAdvisors;
    }

    /**
     *获取增强器
     * @return
     */
    public List<SelfAdvisor> buildAspectJAdvisors() {

        List<SelfAdvisor> candidateAdvisors = new ArrayList<>();

        if (aspectJNames.isEmpty()) {

            String[] beanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(
                    beanFactory, Object.class, true, false);

            for (String beanName : beanNames) {
                Class<?> beanType = beanFactory.getType(beanName);
                if (beanType == null) {
                    continue;
                }
                if (AspectAdvisorsFinder.hasAspectAnnotation(beanType)) {
                    aspectJNames.add(beanName);
                    List<SelfAdvisor> classAdvisors = AspectAdvisorsFinder.getAdvisors(beanType);
                    if (classAdvisors.size() != 0) {
                        this.advisorsCache.put(beanName, classAdvisors);
                    }
                    candidateAdvisors.addAll(classAdvisors);
                }
            }
        }
        else {
            for (String aspectName : aspectJNames) {
                List<SelfAdvisor> cachedAdvisors = this.advisorsCache.get(aspectName);
                if (cachedAdvisors != null) {
                    candidateAdvisors.addAll(cachedAdvisors);
                }
            }
        }
        return candidateAdvisors;
    }

}
