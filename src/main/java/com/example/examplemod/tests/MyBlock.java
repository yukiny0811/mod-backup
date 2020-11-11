package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MyBlock extends Block{
    public MyBlock(){
        super(Material.ROCK);
        setCreativeTab(ExampleMod.myCreativeTab);
        setRegistryName("myblock");
        setUnlocalizedName(ExampleMod.MODID + "_myblock");
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);

    }
}
