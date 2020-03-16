package com.hong.py.springSourceCode;

import com.hong.py.serviceImpl.ChildBean;
import org.springframework.core.convert.converter.Converter;

/**
 * 自定义类型转换器
 */
public class MyConvertor implements Converter<String, ChildBean> {

    @Override
    public ChildBean convert(String source) {
        if(source == null || source.indexOf(",") == -1){
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = source.split(",");
        ChildBean childBean = new ChildBean();
        childBean.setName(infos[0]);
        childBean.setAge(Integer.valueOf(infos[1]));
        childBean.setHeight(Integer.valueOf(infos[2]));
        return childBean;
    }
}
