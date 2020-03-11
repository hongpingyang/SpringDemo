package com.hong.py.serviceImpl;

public class AutoWireByName {

    private AutoWireByName1 autoWireByName1;

    public AutoWireByName1 getAutoWireByName1() {
        return autoWireByName1;
    }

    public void setAutoWireByName1(AutoWireByName1 autoWireByName1) {
        this.autoWireByName1 = autoWireByName1;
    }

    public void testPrintName() {
        System.out.println(this.autoWireByName1.getName());
    }
}
