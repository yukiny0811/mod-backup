package com.example.examplemod.main.entry;

import com.example.examplemod.ExampleMod;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class MyRecipes {

    public static void register(){
        if(ExampleMod.IS_TEST_ENABLED){
            //MyBlock
            GameRegistry.addRecipe(new ItemStack(MyBlocks.myBlock),
                    "AAA",
                    "AAA",
                    "AAA",
                    'A', new ItemStack(Blocks.DIRT));

            //CreeperEgg
            NBTTagCompound creeperID = new NBTTagCompound();
            creeperID.setString("id", "Creeper");
            ItemStack creeperSpawnEgg = new ItemStack(Items.SPAWN_EGG);
            creeperSpawnEgg.setTagInfo("EntityTag", creeperID);
            GameRegistry.addRecipe(creeperSpawnEgg,
                    " A ",
                    "ABA",
                    " A ",
                    'A', new ItemStack(Items.SKULL, 1, 4),
                    'B', new ItemStack(Blocks.TNT));
        }
    }

}
