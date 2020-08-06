package com.dailyaccumulation.pattern.EventDelegation;

import java.util.Date;

public class PlayingGameListener {
    public PlayingGameListener(){
        System.out.println("我正在玩游戏， 开始时间" + new Date());
    }

    public void stopPlay(Date date){
        System.out.println("老师来了， 快回到座位上， 结束时间" + new Date());
    }
}