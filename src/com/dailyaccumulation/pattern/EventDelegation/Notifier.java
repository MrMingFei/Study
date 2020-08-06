package com.dailyaccumulation.pattern.EventDelegation;

public abstract class Notifier {
    private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler(){
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    //增加需要帮忙放哨的学生
    public abstract void addListener(Object object, String methodName, Object... args);

    public abstract void notifyX();
}