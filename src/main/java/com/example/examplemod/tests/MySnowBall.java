package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class MySnowBall extends ItemSnowball {
    public MySnowBall(){
        setCreativeTab(ExampleMod.myCreativeTab);
        setRegistryName("mysnowball");
        setUnlocalizedName(ExampleMod.MODID + "_mysnowball");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if(!playerIn.capabilities.isCreativeMode){
            itemStackIn.stackSize -= 1;
        }

        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
        if(!worldIn.isRemote){
            EntityMySnowball entity = new EntityMySnowball(worldIn, playerIn);
            entity.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0f, 1.5f, 1f);
            worldIn.spawnEntityInWorld(entity);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }
}
