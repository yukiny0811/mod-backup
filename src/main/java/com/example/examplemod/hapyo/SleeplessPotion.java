package com.example.examplemod.hapyo;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.DamageSource;

public class SleeplessPotion extends Potion {
    public SleeplessPotion(){
        super(true, 0xabffaa);
        setPotionName("sleepless");
    }

    @Override
    public boolean isInstant() {
        return true;
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int p_76394_2_) {
        ((EntityPlayer)entityLivingBaseIn).addExhaustion(0.025F * (float)(p_76394_2_ + 1));
        entityLivingBaseIn.attackEntityFrom(DamageSource.wither, 1.0F);
        System.out.println("test");
    }
}
