package com.example.examplemod.main.entry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.main.block.PhotoBlock;
import com.example.examplemod.tests.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MyBlocks {

    public static Block myBlock;
    public static Block myBlock2;
    public static Block fortuneBlock;
    public static Block rainbowBlock;
    public static Block jumpBlock;
    public static Block soundBlock;
    public static Block myRedstoneBlock;
    public static Block myRedstoneBlock2;
    public static Block footPrintSandBlock;
    public static Block dropItemBlock;
    public static Block photoBlock;

    public static void init(){
        myBlock             = new MyBlock();
        myBlock2            = new MyBlock2();
        fortuneBlock        = new FortuneBlock();
        rainbowBlock        = new RainbowBlock();
        jumpBlock           = new JumpBlock();
        soundBlock          = new SoundBlock();
        myRedstoneBlock     = new MyRedstoneBlock();
        myRedstoneBlock2    = new MyRedstoneBlock2();
        footPrintSandBlock  = new FootPrintSandBlock();
        dropItemBlock       = new DropItemBlock();
        photoBlock          = new PhotoBlock();
    }

    public static void register(boolean isClient){
        if(ExampleMod.IS_TEST_ENABLED){
            registerBlock(myBlock, isClient);
            registerBlock(myBlock2, isClient);
            registerBlock(fortuneBlock, isClient);
            registerBlock(rainbowBlock, isClient);
            registerBlock(jumpBlock, isClient);
            registerBlock(soundBlock, isClient);
            registerBlock(myRedstoneBlock, isClient);
            registerBlock(myRedstoneBlock2, isClient);
            registerBlock(footPrintSandBlock, isClient);
            registerBlock(dropItemBlock, isClient);
            registerBlock(photoBlock, isClient);
        }
    }

    private static void registerBlock(Block block, boolean isClient){
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        if(isClient){
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }
}
