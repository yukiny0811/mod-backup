package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;

public class FortuneBlock extends Block {
    public FortuneBlock(){
        super(Material.ROCK);
        setCreativeTab(ExampleMod.myCreativeTab);
        setHardness(30);
        setRegistryName("fortuneblock");
        setUnlocalizedName(ExampleMod.MODID + "_fortuneblock");
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);
        String message = "Life is Tech!";
        Random random = new Random();
        int randomNumber = random.nextInt(5);

        ItemStack heldItem = playerIn.getHeldItemMainhand();
        if(heldItem != null){
            if(heldItem.getItem() == Items.GOLDEN_APPLE){
                message = "Golden Apple!";
            }
        }

        if(!worldIn.isRemote){
            playerIn.addChatComponentMessage(new TextComponentString(message + Integer.toString(randomNumber)));

        }
    }
}
