package com.hong.py.serviceImpl;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * 属性编辑器注册
 */
public class PropertyEditorRegisterDemo implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(ChildBean.class, new SelfPropertyEditor());
    }
}
