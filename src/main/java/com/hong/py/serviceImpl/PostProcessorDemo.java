package com.hong.py.serviceImpl;

import com.hong.py.springSourceCode.MyBeanFactoryAware;

public class PostProcessorDemo {

    private MyBeanFactoryAware myBeanFactoryAware;

    public MyBeanFactoryAware getMyBeanFactoryAware() {
        return myBeanFactoryAware;
    }

    public void setMyBeanFactoryAware(MyBeanFactoryAware myBeanFactoryAware) {
        this.myBeanFactoryAware = myBeanFactoryAware;
    }

   public void Test() {
       this.myBeanFactoryAware.AddBean();
   }

}
