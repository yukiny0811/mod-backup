package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ExplosionSword extends ItemSword {
    public ExplosionSword(){
        super(EnumHelper.addToolMaterial("explosionsword", 4, 200, 16.0f, 1.0f, 22));
        setCreativeTab(ExampleMod.myCreativeTab);
        setRegistryName("explosionsword");
        setUnlocalizedName(ExampleMod.MODID + "_explosionsword");
    }

//    @Override
//    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
//        if(attacker == null){
//            return super.hitEntity(stack, target, attacker);
//        }
//        if(!(attacker instanceof EntityPlayer)){
//            return super.hitEntity(stack, target, attacker);
//        }
//        attacker.getEntityWorld().createExplosion(null, target.posX, target.posY, target.posZ, 10, true);
//        return super.hitEntity(stack, target, attacker);
//    }


    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

        World world = target.worldObj;

        BlockPos spawnPos = target.getPosition();

        Entity entity;
        if (target instanceof EntityVillager) {
            entity = new EntityZombie(world);
            entity.setPosition(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
        } else {
            entity = new EntityPig(world);
            entity.setPosition(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
        }
        world.spawnEntityInWorld(entity);

        target.setDead();





        if (target instanceof EntityVillager) {


        } else {


        }






        return super.hitEntity(stack, target, attacker);






    }






}
