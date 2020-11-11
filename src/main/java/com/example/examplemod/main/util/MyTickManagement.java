package com.example.examplemod.main.util;

public interface MyTickManagement {
    default void setValueToMyTickManager(Runnable runner, int delay){
        MyTickManager.runner.add(runner);
        MyTickManager.delay.add(delay);
        MyTickManager.delayCount.add(0);
    }
}
