package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MyRedstoneBlock extends Block {

    private static final PropertyInteger STATE = PropertyInteger.create("state", 0, 3);

    public MyRedstoneBlock(){
        super(Material.ROCK);
        setCreativeTab(ExampleMod.myCreativeTab);
        setRegistryName("myredstoneblock");
        setUnlocalizedName(ExampleMod.MODID + "_myredstoneblock");
        setHardness(30);
        setDefaultState(getBlockState().getBaseState().withProperty(STATE, 0));
    }

    @Override
    public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
        int power = worldIn.isBlockIndirectlyGettingPowered(pos);
        if(power != 0){
            System.out.println("start input");
        } else {
            System.out.println("end input");
        }
        worldIn.setBlockState(pos, state.withProperty(STATE, power / 4));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(STATE, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(STATE);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, STATE);
    }
}
