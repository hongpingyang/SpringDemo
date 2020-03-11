package com.hong.py.serviceImpl;

public class IdRefDemo {

    private ChildBean childBean;

    public IdRefDemo(ChildBean testChild) {
        this.childBean = testChild;
    }

    public ChildBean getChildBean() {
        return childBean;
    }

    public void setChildBean(ChildBean childBean) {
        this.childBean = childBean;
    }

    @Override
    public String toString() {
        return "IdRefDemo{" +
                "childBean=" + childBean +
                '}';
    }
}
