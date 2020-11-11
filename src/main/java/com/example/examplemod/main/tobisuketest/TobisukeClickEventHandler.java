package com.example.examplemod.main.tobisuketest;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.main.util.MyCapabilities;
import com.example.examplemod.main.util.MyCapabilityProvider;
import com.example.examplemod.tests.EntityTobisuke;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TobisukeClickEventHandler {
    @SubscribeEvent
    public void onRightClicked(PlayerInteractEvent.EntityInteractSpecific event){
        if(event.getTarget().getEntityWorld().isRemote){
            return;
        }
        if(event.getTarget() == null){
            return;
        }
        System.out.println(event.getTarget());
        System.out.println("yayyayaaa");
        if(event.getTarget() instanceof EntityTobisuke){
            EntityTobisuke tobisuke = (EntityTobisuke) event.getTarget();
            TobisukeCapabilities cap = tobisuke.getCapability(TobisukeCapabilityProvider.TOBI_CAP, null);
            if(cap.getItemName().equals("nullitem")){
                EntityPlayer player = Minecraft.getMinecraft().thePlayer;
//                player.inventory.currentItem -= 1;
                player.addChatComponentMessage(new TextComponentString(cap.getItemName()));
//                cap.setItemName("apple");
            } else {
                EntityPlayer player = Minecraft.getMinecraft().thePlayer;
                player.addChatComponentMessage(new TextComponentString(cap.getItemName()));
//                cap.setItemName("nullitem");
//                tobisuke.dropItem(Items.APPLE, 1);
            }
        }
    }
}