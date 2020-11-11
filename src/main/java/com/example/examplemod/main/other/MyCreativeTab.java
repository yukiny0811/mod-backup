package com.example.examplemod.main.other;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class MyCreativeTab extends CreativeTabs {
    public MyCreativeTab(String label){
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return Items.DIAMOND;
    }
}
