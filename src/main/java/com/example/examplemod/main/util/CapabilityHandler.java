package com.example.examplemod.main.util;

import com.example.examplemod.ExampleMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
    public static final ResourceLocation MY_CAP = new ResourceLocation(ExampleMod.MODID, "mycap");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event){
        if(!(event.getObject() instanceof EntityPlayer)){
            return;
        }
        event.addCapability(MY_CAP, new MyCapabilityProvider());
    }
}
