package com.example.examplemod.main.util;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.main.entry.Organizer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderMyHudEvent {

//    @SubscribeEvent
//    public void doRender(RenderGameOverlayEvent.Post event){
//        if (event.getType() != null && event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
//            if(Minecraft.getMinecraft().thePlayer == null){
//                return;
//            }
//            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
//            if(Minecraft.getMinecraft().theWorld == null){
//                return;
//            }
//            World world = Minecraft.getMinecraft().theWorld;
//            GuiScreen gui = Minecraft.getMinecraft().currentScreen;
//            if (player != null && world != null && gui == null && !player.isSpectator()) {
//
//                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//                GlStateManager.enableBlend();
//
//                int sizeX = event.getResolution().getScaledWidth();
//                int sizeY = event.getResolution().getScaledHeight();
//
//                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
//                        GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
//                        GlStateManager.DestFactor.ZERO);
//
//                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(ExampleMod.MODID, "textures/test/test.png"));
//
//
//                int left = sizeX / 2 - 91;
//                int top = sizeY - 39;
//
//                for(int i = 0; i < Organizer.sleepCount; i++){
//                    drawDispTexture(left + i * 9, top - 9 - 3, 9, 9);
//                }
//
//                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//            }
//        }
//
//
//    }

    public void drawTexturedModalRect(int x, int y, int tX, int tY, int width, int height) {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();
        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
        vertexbuffer.pos(x + 0, y + height, -90.0F).tex((tX + 0) * f, (tY + height) * f1).endVertex();
        vertexbuffer.pos(x + width, y + height, -90.0F).tex((tX + width) * f, (tY + height) * f1).endVertex();
        vertexbuffer.pos(x + width, y + 0, -90.0F).tex((tX + width) * f, (tY + 0) * f1).endVertex();
        vertexbuffer.pos(x + 0, y + 0, -90.0F).tex((tX + 0) * f, (tY + 0) * f1).endVertex();
        tessellator.draw();
    }

    public void drawDispTexture(int x, int y, int width, int height) {
        float f = 0.00390625F * 256;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();
        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
        vertexbuffer.pos(x + 0, y + height, -90.0F).tex(0, f).endVertex();
        vertexbuffer.pos(x + width, y + height, -90.0F).tex(f, f).endVertex();
        vertexbuffer.pos(x + width, y + 0, -90.0F).tex(f, 0).endVertex();
        vertexbuffer.pos(x + 0, y + 0, -90.0F).tex(0, 0).endVertex();
        tessellator.draw();
    }
}
