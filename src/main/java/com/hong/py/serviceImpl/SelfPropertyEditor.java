package com.hong.py.serviceImpl;

import java.beans.PropertyEditorSupport;

/**
 * 自定义属性编辑器
 * 既然有了PropertyEditor，那为何还需要有Converter呢？其实是因为Java原生的PropertyEditor存在以下两点不足：
 *
 * 只能用于字符串和Java对象的转换，不适用于任意两个Java类型之间的转换；
 * 对源对象及目标对象所在的上下文信息（如注解、所在宿主类的结构等）不敏感，在类型转换时不能利用这些上下文信息实施高级转换逻辑。
 *
 * Converter or PropertyEditor？
 * Spring有两种自动类型转换器，一种是Converter,一种是PropertyEditor。
 *
 * Converter是类型转换成类型，Editor:从string类型转换为其他类型。
 *  从某种程度上，Converter包含Editor。如果出现需要从string转换到其他类型。首选Editor。
 *
 *  TypeConverterDelegater先使用PropertyEditor转换器器转换，如果没找到对应的转换器器，会⽤ConversionService来进⾏行行对象转换
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
