package com.example.examplemod.main.tobisuketest;

import com.example.examplemod.ExampleMod;
import net.minecraft.item.Item;

public class NullItem extends Item {
    public NullItem(){
        setRegistryName("nullitem");
        setUnlocalizedName(ExampleMod.MODID + "_nullitem");
    }
}
