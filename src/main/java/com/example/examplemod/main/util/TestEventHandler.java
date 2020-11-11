package com.example.examplemod.main.util;

import com.example.examplemod.main.entry.Organizer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class TestEventHandler {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
        EntityPlayer player = event.player;
        MyCapabilities cap = player.getCapability(MyCapabilityProvider.MY_CAP, null);
        player.addChatComponentMessage(new TextComponentString(String.valueOf(cap.getSleepless())));
        Organizer.sleeplessValue = cap.getSleepless();
    }
    @SubscribeEvent
    public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event){
        EntityPlayer player = event.player;
        MyCapabilities cap = player.getCapability(MyCapabilityProvider.MY_CAP, null);
        cap.setSleepless(Organizer.sleeplessValue);
    }

    @SubscribeEvent
    public void OnPlayerDeath(LivingDeathEvent event){
        if(event.getEntity() instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) event.getEntity();
            MyCapabilities cap = player.getCapability(MyCapabilityProvider.MY_CAP, null);
            Organizer.sleeplessValue = 100000;
            cap.setSleepless(Organizer.sleeplessValue);
        }
    }
}
