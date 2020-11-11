package com.example.examplemod.main.block;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.main.entry.Organizer;
import com.example.examplemod.main.util.MyTickManagement;
import com.example.examplemod.main.util.MyTickManager;
import com.example.examplemod.main.util.RenderTickManagement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.ScreenshotEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.http.io.BufferInfo;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

import static org.lwjgl.opengl.GL11.*;

public class PhotoEvent {

//    private IntBuffer bb;

    public static boolean isImageIs = false;

    @SubscribeEvent
    public void onSnap(RenderGameOverlayEvent.Post event) {
        if (event.getType() != null && event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            if (!PhotoBlock.canSnap) {
                return;
            }
//        PhotoBlock.canSnap = false;

            image = null;
            image = ScreenShotHelper.createScreenshot(event.getResolution().getScaledWidth(), event.getResolution().getScaledHeight(), Minecraft.getMinecraft().getFramebuffer());
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    int rgb = image.getRGB(j, i);
                    Color color = Color.decode(String.valueOf(rgb));
                    int r = color.getRed();
                    int g = color.getBlue();
                    int b = color.getGreen();
                    r = Math.round(r / 2);
                    g = Math.round(g / 3 * 2);
                    Color colornew = new Color(r, g, b);
                    String hex = Integer.toHexString(colornew.getRGB()).substring(2);
                    image.setRGB(j, i, Integer.parseInt(hex, 16));
                }
            }
        }
    }

    @SubscribeEvent
    public void render(RenderGameOverlayEvent.Post event){
        if(!PhotoBlock.canSnap){
            return;
        }
        if(image == null){
            return;
        }
        if (event.getType() != null && event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            if(Minecraft.getMinecraft().thePlayer == null){
                return;
            }
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            if(Minecraft.getMinecraft().theWorld == null){
                return;
            }
            World world = Minecraft.getMinecraft().theWorld;
            GuiScreen gui = Minecraft.getMinecraft().currentScreen;
            if (player != null && world != null && gui == null && !player.isSpectator()) {

                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GlStateManager.enableBlend();

                int sizeX = event.getResolution().getScaledWidth();
                int sizeY = event.getResolution().getScaledHeight();

                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
                        GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
                        GlStateManager.DestFactor.ZERO);

                DynamicTexture texture = new DynamicTexture(image);
                Minecraft.getMinecraft().getTextureManager().bindTexture(Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation("nameTest", texture));

                int left = sizeX / 2 - 91;
                int top = sizeY - 39;

                    drawDispTexture(0, 0, sizeX, sizeY);

                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }




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

    private BufferedImage image;

//
//    @SubscribeEvent
//    public void screenshot(ScreenshotEvent event){
//        event.setCanceled(true);
//        image = event.getImage();
//        PhotoBlock.canSnap = true;
//    }
}
