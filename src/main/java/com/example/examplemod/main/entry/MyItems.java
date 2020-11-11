package com.example.examplemod.main.entry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.main.tobisuketest.NullItem;
import com.example.examplemod.tests.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MyItems {

    public static Item magicStick;
    public static Item hiPotion;
    public static Item mySword;
    public static Item lightningSword;
    public static Item newPotion;
    public static Item mySnowBall;
    public static Item explosiveArrow;
    public static Item explosionSword;
    public static Item nullitem;

    public static void init(){
        magicStick      = new MagicStickItem();
        hiPotion        = new HiPotion();
        mySword         = new MySword();
        lightningSword  = new LightningSword();
        newPotion       = new newPotion();
        mySnowBall      = new MySnowBall();
        explosiveArrow  = new ExplosiveArrow();
        explosionSword  = new ExplosionSword();
        nullitem        = new NullItem();
    }

    public static void register(boolean isClient){
        if(ExampleMod.IS_TEST_ENABLED){
            registerItem(magicStick, isClient);
            registerItem(hiPotion, isClient);
            registerItem(mySword, isClient);
            registerItem(lightningSword, isClient);
            registerItem(newPotion, isClient);
            registerItem(mySnowBall, Items.SNOWBALL, isClient);
            registerItem(explosiveArrow, isClient);
            registerItem(explosionSword, Items.DIAMOND_SWORD, isClient);
            registerItem(nullitem, isClient);
        }
    }

    private static void registerItem(Item item, boolean isClient){
        GameRegistry.register(item);
        if(isClient){
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }

    private static void registerItem(Item item, Item textureItem, boolean isClient){
        GameRegistry.register(item);
        if(isClient){
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(textureItem.getRegistryName(), "inventory"));
        }
    }
}
