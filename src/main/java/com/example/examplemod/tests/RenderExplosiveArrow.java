package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderExplosiveArrow extends RenderArrow<EntityExplosiveArrow> {
    private static final ResourceLocation TEXTURE_EXPLOSIVE_ARROW = new ResourceLocation(ExampleMod.MODID, "textures/entity/explosivearrow.png");
    public RenderExplosiveArrow(RenderManager manager){
        super(manager);
    }
    protected ResourceLocation getEntityTexture(EntityExplosiveArrow entity){
        return TEXTURE_EXPLOSIVE_ARROW;
    }
}
