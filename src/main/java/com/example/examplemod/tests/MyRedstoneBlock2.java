package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class MyRedstoneBlock2 extends Block {

    private static final PropertyInteger POWER = PropertyInteger.create("power", 0, 1);

    public MyRedstoneBlock2(){
        super(Material.ROCK);
        setRegistryName("myredstoneblock2");
        setUnlocalizedName(ExampleMod.MODID + "_myredstoneblock2");
        setCreativeTab(ExampleMod.myCreativeTab);
        setHardness(30);
        setDefaultState(getBlockState().getBaseState().withProperty(POWER, 0));
    }

    @Override
    public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public boolean canProvidePower(IBlockState state) {
        return true;
    }

    @Override
    public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        if(blockState.getValue(POWER) == 1){
            return 15;
        } else {
            return 0;
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(POWER, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(POWER);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, POWER);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        int power = state.getValue(POWER);

        if(power == 0){
            worldIn.setBlockState(pos, state.withProperty(POWER, 1));
        } else {
            worldIn.setBlockState(pos, state.withProperty(POWER, 0));
        }

        worldIn.scheduleBlockUpdate(pos, this, 5, 100);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.scheduleBlockUpdate(pos, this, 5, 100);
    }
}
