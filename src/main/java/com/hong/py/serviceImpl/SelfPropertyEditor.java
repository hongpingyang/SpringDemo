package com.hong.py.serviceImpl;

import java.beans.PropertyEditorSupport;

/**
 * 自定义属性编辑器
 */
public class SelfPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text == null || text.indexOf(",") == -1){
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = text.split(",");
        ChildBean childBean = new ChildBean();
        childBean.setName(infos[0]);
        childBean.setAge(Integer.valueOf(infos[1]));
        childBean.setHeight(Integer.valueOf(infos[2]));

        setValue(childBean);
    }

}
