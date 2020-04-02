package com.hong.py.springSourceCode;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/2 12:32
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/2 12:32
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
public class MyImportSelector implements ImportSelector {

    /**
     * 导入ParentBean
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.hong.py.serviceImpl.ParentBean"};
    }
}
