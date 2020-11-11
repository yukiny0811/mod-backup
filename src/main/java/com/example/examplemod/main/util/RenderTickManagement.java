package com.example.examplemod.main.util;

public interface RenderTickManagement {
    default void setValueToMyTickManager(Runnable runner, int delay){
        MyTickManager.renderRunner.add(runner);
        MyTickManager.renderDelay.add(delay);
        MyTickManager.renderDelayCount.add(0);
    }
}
