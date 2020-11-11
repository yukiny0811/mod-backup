package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ExplosiveArrow extends ItemArrow {
    public ExplosiveArrow(){
        super();
        setRegistryName("explosivearrow");
        setUnlocalizedName(ExampleMod.MODID + "_explosivearrow");
        setCreativeTab(ExampleMod.myCreativeTab);
    }

    @Override
    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
        return new EntityExplosiveArrow(worldIn, shooter);
    }
}
