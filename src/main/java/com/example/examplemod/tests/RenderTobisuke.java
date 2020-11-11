package com.example.examplemod.tests;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTobisuke extends RenderLiving<EntityTobisuke> {
    private static final ResourceLocation tobisukeTexture = new ResourceLocation("examplemod:textures/entity/tobisuke.png");

    public RenderTobisuke(RenderManager renderManagerIn){
        super(renderManagerIn, new ModelTobisuke(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTobisuke entity) {
        return tobisukeTexture;
    }
}
