package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JumpBlock extends Block {
    public JumpBlock(){
        super(Material.CLAY);
        setRegistryName("jumpblock");
        setUnlocalizedName(ExampleMod.MODID + "_jumpblock");
        setHardness(2.5f);
        setCreativeTab(ExampleMod.myCreativeTab);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof EntityPlayer){
            ((EntityPlayer)entityIn).addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 10, 10));
            ((EntityPlayer)entityIn).jump();
        }
    }
}
