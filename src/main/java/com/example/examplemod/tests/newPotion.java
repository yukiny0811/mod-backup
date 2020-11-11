package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.ArrayList;

public class newPotion extends ItemFood {

    private static final PotionEffect EFFECT = new PotionEffect(MobEffects.SPEED, 200, 0);
    private static final Item TARGET_ITEM = Items.APPLE;

    public newPotion() {
        super(1, 0.5f, false);
        setCreativeTab(ExampleMod.myCreativeTab);
        setRegistryName("newpotion");
        setUnlocalizedName(ExampleMod.MODID + "_newpotion");
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        //スーパーメソッドの呼び出し
        super.onFoodEaten(stack, worldIn, player);

        //プレイヤーのインベントリを指定
        InventoryPlayer inventory = player.inventory;

        //インベントリの各スロットを繰りかえす
        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            //各スロットに入っているアイテムスタック
            ItemStack nowStack = inventory.getStackInSlot(i);

            //スロットの中身がからなら、次の繰り返しへ
            if (nowStack == null) continue;

            if(nowStack.getItem() != TARGET_ITEM) continue;

            //スロットの中のスタック数が1ならば、
            if (nowStack.stackSize == 1) {
                //スロットをからにする
                inventory.setInventorySlotContents(i, null);
            } else {
                //スタック数を1減らす
                nowStack.stackSize--;
            }
            //プレイヤーにポーションエフェクトを付与して処理をやめる
            player.addPotionEffect(EFFECT);
            return;
        }
        //アイテムを持っていないようだから、食べたポーションを元の数に戻す
        stack.stackSize++;
    }
}
