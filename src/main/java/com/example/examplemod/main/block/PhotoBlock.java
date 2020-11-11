package com.example.examplemod.main.block;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.main.util.RenderTickManagement;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PhotoBlock extends Block implements RenderTickManagement {

    public static boolean canSnap = false;
    public PhotoBlock(){
        super(Material.ROCK);
        setRegistryName("photoblock");
        setUnlocalizedName(ExampleMod.MODID + "yay");
        setCreativeTab(ExampleMod.myCreativeTab);
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        canSnap = true;
        setValueToMyTickManager(() -> {
            PhotoBlock.canSnap = false;
        }, 10);
    }
}
