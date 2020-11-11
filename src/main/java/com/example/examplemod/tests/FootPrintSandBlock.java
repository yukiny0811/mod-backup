package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class FootPrintSandBlock extends BlockFalling {

    private static final PropertyInteger COLOR = PropertyInteger.create("color", 0, 4);
    private static final AxisAlignedBB BLOCK_COLLISION = new AxisAlignedBB(0, 0, 0, 1, 0.9f, 1);

    public FootPrintSandBlock(){
        super(Material.SAND);
        setCreativeTab(ExampleMod.myCreativeTab);
        setRegistryName("footprintsandblock");
        setUnlocalizedName(ExampleMod.MODID + "_footprintsandblock");
        setDefaultState(getBlockState().getBaseState().withProperty(COLOR, 0));
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

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if(entityIn instanceof EntityPlayer && state.getValue(COLOR) != 4){
            worldIn.setBlockState(pos, state.withProperty(COLOR, 4));
            worldIn.scheduleBlockUpdate(pos.toImmutable(), this, 5, 100);
        }
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
        return BLOCK_COLLISION;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);
        int next = state.getValue(COLOR) - 1;
        if(next >= 1){
            worldIn.setBlockState(pos, state.withProperty(COLOR, next));
            worldIn.scheduleBlockUpdate(pos, this, 5, 100);
        }
    }


}
