package com.example.examplemod.main.event;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;

public class EasyCut {
    private static final int MAX_DEPTH = 5;
    private static final Item[] EVENT_ITEM = {Items.WOODEN_AXE, Items.STONE_AXE, Items.IRON_AXE, Items.GOLDEN_AXE, Items.DIAMOND_AXE};
    private static final Block[] EVENT_BLOCK = {Blocks.LOG, Blocks.LOG2};
    private static final Block[] EVENT_BREAKABLE_BLOCK = {Blocks.LOG, Blocks.LOG2, Blocks.LEAVES, Blocks.LEAVES2};

    @SubscribeEvent
    public void OnBlockBreak(BlockEvent.BreakEvent event){
        EntityPlayer player = event.getPlayer();
        if(player == null){
            return;
        }
        if(player.getHeldItemMainhand() == null){
            return;
        }
        Item item = player.getHeldItemMainhand().getItem();
        if(!Arrays.asList(EVENT_ITEM).contains(item)){
            return;
        }
        Block block = event.getState().getBlock();
        if(!Arrays.asList(EVENT_BLOCK).contains(block)){
            return;
        }
        BlockPos pos = event.getPos();
        breakBlock(event.getWorld(), pos, 1);
        event.setCanceled(true);
    }
    private void breakBlock(World world, BlockPos pos, int depth){
        if(depth > MAX_DEPTH){
            return;
        }
        IBlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        if(!Arrays.asList(EVENT_BREAKABLE_BLOCK).contains(block)){
            return;
        }
        block.dropBlockAsItem(world, pos, blockState, 0);
        world.setBlockToAir(pos);
        if(Arrays.asList(EVENT_BLOCK).contains(block)){
            breakBlock(world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), depth);
        }
        breakBlock(world, new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), depth + 1);
        breakBlock(world, new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), depth + 1);
        breakBlock(world, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), depth + 1);
        breakBlock(world, new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), depth + 1);
    }
}
