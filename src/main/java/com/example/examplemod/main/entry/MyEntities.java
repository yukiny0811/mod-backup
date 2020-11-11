package com.example.examplemod.main.entry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.tests.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class MyEntities {

    public static void register(){
        if(ExampleMod.IS_TEST_ENABLED){
            //mySnowBall
            EntityRegistry.registerModEntity(EntityMySnowball.class, "mysnowball", 3, ExampleMod.MODID, 10, 10, true);
            RenderingRegistry.registerEntityRenderingHandler(EntityMySnowball.class, new IRenderFactory<EntityMySnowball>() {
                @Override
                public Render<? super EntityMySnowball> createRenderFor(RenderManager manager) {
                    return new RenderSnowball<EntityMySnowball>(manager, Items.SNOWBALL, Minecraft.getMinecraft().getRenderItem());
                }
            });

            //explosiveArrow
            EntityRegistry.registerModEntity(EntityExplosiveArrow.class, "explosivearrow", 0, ExampleMod.MODID, 10, 10, true);
            RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveArrow.class, new IRenderFactory<EntityExplosiveArrow>() {
                @Override
                public Render<? super EntityExplosiveArrow> createRenderFor(RenderManager manager) {
                    return new RenderExplosiveArrow(manager);
                }
            });

            //tobisuke
            EntityRegistry.registerModEntity(EntityTobisuke.class, "tobisuke", EntityTobisuke.ENTITY_ID, ExampleMod.MODID, 100, 2, true, 0xff0000, 0x00ff00);
            EntityRegistry.addSpawn(EntityTobisuke.class, 20, 15, 30, EnumCreatureType.CREATURE, Biomes.PLAINS);
            RenderingRegistry.registerEntityRenderingHandler(EntityTobisuke.class, RenderTobisuke::new);


        }
    }
}
