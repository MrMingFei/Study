package com.dailyaccumulation.javaapi.callbackfunction;

public interface DoJob {

    /**
     * student通过自身callHelp调用SuperCalculator的add方法，调用的时候的引用（this）当做参数
     * 传入，SuperCalculator计算结果之后，回调了student的fillBlank方法，fillBlank就是回调函数
     */
    public void fillBlank(int a, int b, int result);
}
