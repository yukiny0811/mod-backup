package com.example.examplemod.tests;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelTobisuke extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;

    public ModelTobisuke(){
        float f = 4f;

        head = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);

        head.setTextureOffset(0, 0);
        head.addBox(-3f, -1f, -7f, 6, 6, 6);

        head.setTextureOffset(24, 0);
        head.addBox(-1.5f, 3f, -8f, 3, 1, 1);
        head.setRotationPoint(0f, 0f + f + 9f, 0f);

        body = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);

        body.setTextureOffset(0, 18);
        body.addBox(-4.5f, -6f, -7.5f, 9, 6, 12);

        body.setTextureOffset(30, 0);
        body.addBox(-5.5f, -5f, -7f, 1, 4, 8);

        body.setTextureOffset(30, 0);
        body.addBox(4.5f, -5f, -7f, 1, 4, 8);
        body.setRotationPoint(0f, 0f + f + 20f, 0f);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        head.rotateAngleY = netHeadYaw / (180f / (float) Math.PI) * 0.25f;
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        head.render(scale);
        body.render(scale);
    }
}
