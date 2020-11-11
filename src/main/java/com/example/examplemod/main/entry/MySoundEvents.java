package com.example.examplemod.main.entry;

import com.example.examplemod.ExampleMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MySoundEvents {

    public static SoundEvent soundEvent1;
    public static SoundEvent soundEvent2;
    public static SoundEvent soundEvent3;

    public static void init(){
        soundEvent1 = new SoundEvent(new ResourceLocation(ExampleMod.MODID, "sound1"));
        soundEvent2 = new SoundEvent(new ResourceLocation(ExampleMod.MODID, "sound2"));
        soundEvent3 = new SoundEvent(new ResourceLocation(ExampleMod.MODID, "sound3"));
    }

    public static void register(){
        if(ExampleMod.IS_TEST_ENABLED){
            registerSoundEvent(soundEvent1);
            registerSoundEvent(soundEvent2);
            registerSoundEvent(soundEvent3);
        }
    }

    private static void registerSoundEvent(SoundEvent event){
        GameRegistry.register(event, event.getSoundName());
    }
}
