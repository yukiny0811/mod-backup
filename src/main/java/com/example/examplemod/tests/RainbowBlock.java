package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RainbowBlock extends Block {
    private static final PropertyInteger COLOR = PropertyInteger.create("color", 0, 6);

    public RainbowBlock(){
        super(Material.ROCK);
        setCreativeTab(ExampleMod.myCreativeTab);
        setRegistryName("rainbowblock");
        setUnlocalizedName(ExampleMod.MODID + "_rainbowblock");
        setHardness(300);
        setDefaultState(blockState.getBaseState().withProperty(COLOR, 0));
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        IBlockState blockState = worldIn.getBlockState(pos);
        int color = blockState.getValue(COLOR);
        color += 1;
        if(color >= 7){
            color = 0;
        }
        worldIn.setBlockState(pos, blockState.withProperty(COLOR, color));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(COLOR, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(COLOR);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, COLOR);
    }
}
