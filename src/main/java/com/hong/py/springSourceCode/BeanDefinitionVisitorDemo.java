package com.hong.py.springSourceCode;

import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.util.StringValueResolver;

public class BeanDefinitionVisitorDemo {
    public static void main(String[] args) {

        StringValueResolver stringValueResolver=new StringValueResolver() {
            @Override
            public String resolveStringValue(String strVal) {
                if(strVal.equals("洪大洋"))
                   return "hongpy";
                else
                    return strVal;
            }
        };

        BeanDefinitionVisitor beanDefinitionVisitor=new BeanDefinitionVisitor(stringValueResolver);

    }
}
