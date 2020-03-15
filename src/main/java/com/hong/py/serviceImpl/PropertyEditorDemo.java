package com.hong.py.serviceImpl;

public class PropertyEditorDemo {

    private  String name;


    private ChildBean childBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChildBean getChildBean() {
        return childBean;
    }

    public void setChildBean(ChildBean childBean) {
        this.childBean = childBean;
    }


    @Override
    public String toString() {
        return "PropertyEditorDemo{" +
                "name='" + name + '\'' +
                ", childBean=" + childBean +
                '}';
    }


}
