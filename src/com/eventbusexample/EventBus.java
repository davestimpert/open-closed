package com.eventbusexample;

public interface EventBus {

    void register(Object object);

    void post(Object event);
}
