package com.example.examplemod.main.tobisuketest;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.tests.EntityTobisuke;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TobisukeCapabilityHandler {

    public static final ResourceLocation TOBI_CAP = new ResourceLocation(ExampleMod.MODID, "tobicap");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event){
        if(!(event.getObject() instanceof EntityTobisuke)){
            return;
        }
        event.addCapability(TOBI_CAP, new TobisukeCapabilityProvider());
    }
}