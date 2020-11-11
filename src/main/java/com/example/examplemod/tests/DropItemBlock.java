package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DropItemBlock extends Block {
    public DropItemBlock(){
        super(Material.ROCK);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setRegistryName("drop_item_block");
        setUnlocalizedName(ExampleMod.MODID + "_drop_item_block");
        setHardness(30);
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);
        ItemStack stack = new ItemStack(Items.BREAD);
        EntityItem entityItem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
        entityItem.setDefaultPickupDelay();
        if(!worldIn.isRemote){
            worldIn.spawnEntityInWorld(entityItem);
        }
    }
}
