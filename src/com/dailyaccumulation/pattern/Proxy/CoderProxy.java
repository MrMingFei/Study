package com.dailyaccumulation.pattern.Proxy;

public class CoderProxy implements ICoder {

    private ICoder coder;

    public CoderProxy(ICoder coder){
        this.coder = coder;
    }

    //在这里，通过CoderProxy的implDemands实现代理，实际有JavaCoder的
    //implDemands完成工作。除此之外，还可以通过代理类扩展被代理类的功能
    @Override
    public void implDemands(String demandName) {
        coder.implDemands(demandName);
    }
}
