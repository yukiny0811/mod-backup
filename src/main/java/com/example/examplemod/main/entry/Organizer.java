package com.example.examplemod.main.entry;

import com.example.examplemod.ExampleMod;
import net.minecraft.util.SoundEvent;

public class Organizer {

    public static SoundEvent[] soundEvents_A;
    public static int sleeplessValue;
    public static int sleepCount;
    public static boolean taskToKill;

    public static void init(){
        soundEvents_A = new SoundEvent[]{MySoundEvents.soundEvent1, MySoundEvents.soundEvent2, MySoundEvents.soundEvent3};
        sleeplessValue = 0;
        taskToKill = false;
    }


}
