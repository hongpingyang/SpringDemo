package com.hong.py.springSourceCode.SelfTransactioManage.core;

import com.hong.py.springSourceCode.common.SelfAdvisor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.SelfTransactioManage.core
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/8 17:27
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/8 17:27
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
public class TransactionAdvisorsBuilder {

    private ConfigurableListableBeanFactory beanFactory;

    @Nullable
    private volatile String[] cachedAdvisorBeanNames;

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public List<SelfAdvisor> GetTransactionAdvisors() {
        List<SelfAdvisor> selfAdvisors = buildTransactionAdvisors();
        return selfAdvisors;
    }

    /**
     *获取增强器
     * @return
     */
    public List<SelfAdvisor> buildTransactionAdvisors() {

        List<SelfAdvisor> candidateAdvisors = new ArrayList<>();
        String[] beanNames=cachedAdvisorBeanNames;
        if (beanNames==null) {

            beanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(
                    beanFactory, SelfAdvisor.class, true, false);

            this.cachedAdvisorBeanNames = beanNames;
        }

        if (beanNames.length == 0) {
            return candidateAdvisors;
        }

        for (String beanName : beanNames) {
            Class<?> beanType = beanFactory.getType(beanName);
             if (beanType == null) {
                    continue;
                }
                if (beanFactory.isCurrentlyInCreation(beanName)) {
                    //还在创建中
                } else {
                    SelfAdvisor selfAdvisor = beanFactory.getBean(beanName, SelfAdvisor.class);
                    candidateAdvisors.add(selfAdvisor);
                }
        }

        return candidateAdvisors;
    }

}
