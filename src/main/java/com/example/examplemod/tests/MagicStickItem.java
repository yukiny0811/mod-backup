package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class MagicStickItem extends ItemSword {
    public MagicStickItem(){
        super(EnumHelper.addToolMaterial(
                "magic_stick",
                4,
                200,
                16.0f,
                1.0f,
                22
        ));
        setCreativeTab(ExampleMod.myCreativeTab);
        setRegistryName("magicstickitem");
        setUnlocalizedName(ExampleMod.MODID + "_magicstickitem");
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        int time = 2;
        attacker.setFire(time);

        World world = target.worldObj;
        Entity entity = new EntityPig(world);
        entity.setPosition(target.posX, target.posY, target.posZ);
        BlockPos spawnPos = target.getPosition();
        entity.setPosition(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
        world.spawnEntityInWorld(entity);

        if(target.getClass() == EntityMooshroom.class){
            entity = new EntityZombie(world);
            entity.setPosition(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
            world.spawnEntityInWorld(entity);
        }

        target.setDead();

        return super.hitEntity(stack, target, attacker);
    }
}
