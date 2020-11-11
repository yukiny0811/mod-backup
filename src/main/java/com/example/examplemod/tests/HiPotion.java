package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HiPotion extends ItemFood {
    public HiPotion(){
        super(1, 0.5f, false);
        setCreativeTab(ExampleMod.myCreativeTab);
        setRegistryName("hipotion");
        setUnlocalizedName(ExampleMod.MODID + "_hipotion");
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        Potion potion = MobEffects.SPEED;
        int duration = 200;
        int level = 0;

        int size = stack.stackSize;
        if(size >= 10){
            duration = 600;
            level = 1;
        }

        PotionEffect effect = new PotionEffect(potion, duration, level);
        player.addPotionEffect(effect);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
