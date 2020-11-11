package com.example.examplemod.main.entry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.main.block.PhotoEvent;
import com.example.examplemod.main.event.EasyCut;
import com.example.examplemod.main.tobisuketest.TobisukeCapabilityHandler;
import com.example.examplemod.main.tobisuketest.TobisukeClickEventHandler;
import com.example.examplemod.main.util.CapabilityHandler;
import com.example.examplemod.main.util.MyPlayerSleepEvent;
import com.example.examplemod.main.util.TestEvent;
import com.example.examplemod.main.util.TestEventHandler;
import com.example.examplemod.tests.*;
import net.minecraftforge.common.MinecraftForge;

public class MyEvents {
    public static void register(){
        MinecraftForge.EVENT_BUS.register(new EasyCut());
        if(ExampleMod.IS_TEST_ENABLED){
            MinecraftForge.EVENT_BUS.register(new PlayerDeathEventHandler());
            MinecraftForge.EVENT_BUS.register(new DirtBreakEventHandler());
            MinecraftForge.EVENT_BUS.register(new StoneBreakEventHandler());
            MinecraftForge.EVENT_BUS.register(new MyPlayerSleepEvent());
            MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
            MinecraftForge.EVENT_BUS.register(new TestEventHandler());
            MinecraftForge.EVENT_BUS.register(new TobisukeCapabilityHandler());
            MinecraftForge.EVENT_BUS.register(new TobisukeClickEventHandler());
            MinecraftForge.EVENT_BUS.register(new TestEvent());
            MinecraftForge.EVENT_BUS.register(new PhotoEvent());
        }
    }
}
