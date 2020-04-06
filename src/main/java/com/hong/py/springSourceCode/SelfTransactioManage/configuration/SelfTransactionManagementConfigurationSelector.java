package com.hong.py.springSourceCode.SelfTransactioManage.configuration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 导入2个配置类
 */
public class SelfTransactionManagementConfigurationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{SelfAutoProxyRegistrar.class.getName(),
                SelfProxyTransactionManagementConfiguration.class.getName()};
    }
}
