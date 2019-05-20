package com.dailyaccumulation.pattern.Proxy;

public class JavaCoder implements ICoder {

    private String name;

    public JavaCoder(String name){
        this.name = name;
    }

    @Override
    public void implDemands(String demandName) {
        System.out.println(name + "implemented demand:" + demandName + "in Java");
    }
}
