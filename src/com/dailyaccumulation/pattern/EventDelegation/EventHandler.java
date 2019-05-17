package com.dailyaccumulation.pattern.EventDelegation;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    //使用一个List
    private List<Event> objects;

    public EventHandler(){
        objects = new ArrayList<Event>();
    }

    public void addEvent(Object object, String methodName, Object... args){
        objects.add(new Event(object, methodName, args));
    }

    public void notifyX() throws Exception{
        for (Event e : objects){
            e.invoke();
        }
    }
}
