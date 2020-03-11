package com.hong.py.serviceImpl;

public class AutoWireByConstructor {

    private AutoWireByConstructor1 autoWireByConstructor1;

    public AutoWireByConstructor(AutoWireByConstructor1 autoWireByConstructor1) {
        this.autoWireByConstructor1 = autoWireByConstructor1;
    }

    public void testPrintName() {
        System.out.println(this.autoWireByConstructor1.getName());
    }
}
