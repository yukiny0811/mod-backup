package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MyBlock2 extends Block {
    public MyBlock2() {
        super(Material.ROCK);
        setCreativeTab(ExampleMod.myCreativeTab);
        setUnlocalizedName(ExampleMod.MODID + "_myblock2");
        setRegistryName("myblock2");
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
    }
}
