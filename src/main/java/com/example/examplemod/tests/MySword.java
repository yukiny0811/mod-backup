package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class MySword extends ItemSword {

    public MySword(){
        super(EnumHelper.addToolMaterial("mysword", 4, 200, 16.0f, 1.0f, 22));
        setCreativeTab(ExampleMod.myCreativeTab);
        setRegistryName("mysword");
        setUnlocalizedName(ExampleMod.MODID + "_mysword");
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if(stack == null){
            return true;
        }
        if(!(attacker instanceof EntityPlayer)){
            return true;
        }
        target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1200, 0));

        return true;
    }
}
