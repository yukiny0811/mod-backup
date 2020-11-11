package com.example.examplemod.main.util;

import com.example.examplemod.main.entry.Organizer;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.entity.player.SleepingLocationCheckEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static java.lang.StrictMath.abs;

public class MyPlayerSleepEvent implements MyTickManagement{

    @SubscribeEvent
    public void onPlayerSleep(PlayerWakeUpEvent event) {
        Organizer.sleeplessValue = 0;
        Organizer.sleeplessValue = 0;
        Organizer.sleepCount = 10;
    }

}
