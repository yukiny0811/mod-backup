package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class LightningSword extends ItemSword {

    public LightningSword() {
        super(ToolMaterial.DIAMOND);
        setRegistryName("lightningsword");
        setUnlocalizedName(ExampleMod.MODID + "_lightningsword");
        setCreativeTab(ExampleMod.myCreativeTab);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
        world.addWeatherEffect(new EntityLightningBolt(world, player.posX - 2, player.posY, player.posZ - 2,false));
        world.addWeatherEffect(new EntityLightningBolt(world, player.posX - 2, player.posY, player.posZ,false));
        world.addWeatherEffect(new EntityLightningBolt(world, player.posX - 2, player.posY, player.posZ + 2,false));
        world.addWeatherEffect(new EntityLightningBolt(world, player.posX, player.posY, player.posZ - 2,false));
        world.addWeatherEffect(new EntityLightningBolt(world, player.posX, player.posY, player.posZ + 2,false));
        world.addWeatherEffect(new EntityLightningBolt(world, player.posX + 2, player.posY, player.posZ - 2,false));
        world.addWeatherEffect(new EntityLightningBolt(world, player.posX + 2, player.posY, player.posZ,false));
        world.addWeatherEffect(new EntityLightningBolt(world, player.posX + 2, player.posY, player.posZ + 2,false));
        return super.onItemRightClick(itemStack, world, player,hand);
    }
}
