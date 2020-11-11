package com.example.examplemod.tests;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerDeathEventHandler {

    //持っていると死なないアイテムを指定する。今回はBONE
    private static final Item NOT_DIE_ITEM = Items.BONE;


    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent event) {

        //ワールドがサーバー上で動いていたらこれ以降実行しない
        if (event.getEntityLiving().worldObj.isRemote) {
            return;
        }

        //ダメージを受けたEntityがプレイヤーじゃないならこれ以降実行しない
        if (!(event.getEntityLiving() instanceof EntityPlayer)) {
            return;
        }

        //ダメージを受けたEntityがそのダメージで死なないのならば死なないのならばこr絵以降実行しない
        if (!(event.getEntityLiving().getHealth() - event.getAmount() <= 0)) {
            return;
        }

        //ダメージを受けたEntity（Player）のインベントリを指定
        InventoryPlayer inventory = ((EntityPlayer) event.getEntityLiving()).inventory;

        //インベントリの各スロットを順番に実行
        for (int i = 0; i < inventory.getSizeInventory(); i++) {

            //スロットに入っているItemStackを取得
            ItemStack stack = inventory.getStackInSlot(i);

            if (stack == null) {
                return;
            }

            //スロットに入っているitemStackが指定した死なないアイテむじゃないならば、次のスロットにすすむ
            if (stack.getItem() != NOT_DIE_ITEM) {
                continue;
            }

            //スタック数が1ならば、スロットからItemStackを消す、1でないならばスタック数を1減らす
            if (stack.stackSize == 1) {
                inventory.removeStackFromSlot(i);
            } else {
                stack.stackSize--;
            }

            //Entityがダメージを受けるをというイベントをキャンセルする
            event.setCanceled(true);


            return;
        }
    }
}
