//package com.example.examplemod.main.util;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.GuiGameOver;
//import net.minecraft.client.gui.ScaledResolution;
//import net.minecraft.client.renderer.GlStateManager;
//import net.minecraft.client.renderer.RenderHelper;
//import net.minecraft.client.renderer.Tessellator;
//import net.minecraft.client.renderer.VertexBuffer;
//import net.minecraft.client.renderer.texture.TextureManager;
//import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.gameevent.TickEvent;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//
//@Mod.EventBusSubscriber
//public class TestWindowRender {
//
//    private static Minecraft mc = Minecraft.getMinecraft();
//
//    private static String lastRenderedMessage;
//
//    private static int framebufferWidth;
//    private static int framebufferHeight;
//
//    //mc.player != null ? (!mc.player.isCreative() || EnhancedVisuals.CONFIG.doEffectsInCreative) : true;
//
//    @SubscribeEvent
//    public static void render(TickEvent.RenderTickEvent event){
//
//        if (event.phase == TickEvent.Phase.END && mc.thePlayer != null) {
//
//            if (!(mc.currentScreen instanceof GuiGameOver)) {
//                if (mc.getFramebuffer().framebufferWidth != framebufferWidth || mc.getFramebuffer().framebufferHeight != framebufferHeight) {
//                    framebufferWidth = mc.getFramebuffer().framebufferWidth;
//                    framebufferHeight = mc.getFramebuffer().framebufferHeight;
//                }
//
//                ScaledResolution resolution = new ScaledResolution(mc);
//                int screenWidth = resolution.getScaledWidth();
//                int screenHeight = resolution.getScaledHeight();
//
//                GlStateManager.pushMatrix();
//                TextureManager manager = mc.getTextureManager();
//                float partialTicks = event.renderTickTime;
//
//                RenderHelper.enableStandardItemLighting();
//                GlStateManager.disableLighting();
//                GlStateManager.clear(256);
//                GlStateManager.matrixMode(5889);
//                GlStateManager.loadIdentity();
//                GlStateManager.ortho(0.0D, screenWidth, screenHeight, 0.0D, 1000.0D, 3000.0D);
//                GlStateManager.matrixMode(5888);
//                GlStateManager.loadIdentity();
//                GlStateManager.translate(0.0F, 0.0F, -2000.0F);
//
//                GlStateManager.enableBlend();
//                GlStateManager.disableDepth();
//                GlStateManager.depthMask(false);
//                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
//                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//                GlStateManager.disableAlpha();
//                GlStateManager.enableBlend();
//
//                render();
//
////                renderVisuals(VisualManager.visuals(VisualCategory.overlay), manager, screenWidth, screenHeight, partialTicks);
////                renderVisuals(VisualManager.visuals(VisualCategory.particle), manager, screenWidth, screenHeight, partialTicks);
//
////                GlStateManager.matrixMode(5890);
////                GlStateManager.pushMatrix();
////                GlStateManager.loadIdentity();
////                render();
//////                renderVisuals(VisualManager.visuals(VisualCategory.shader), manager, screenWidth, screenHeight, partialTicks);
////                GlStateManager.popMatrix();
////
////                GlStateManager.depthMask(true);
////                GlStateManager.enableDepth();
////                GlStateManager.enableAlpha();
////                GlStateManager.disableLighting();
////
////                mc.getFramebuffer().bindFramebuffer(false);
////                GlStateManager.matrixMode(5888);
//
//                GlStateManager.popMatrix();
//
//            }
//        }
//    }
//
//    private static void render(){
//        Tessellator tessellator = Tessellator.getInstance();
//        VertexBuffer renderer = tessellator.getBuffer();
//
////        float red = visual.color != null ? visual.color.getRed() / 255.0F : 1;
////        float green = visual.color != null ? visual.color.getGreen() / 255.0F : 1;
////        float blue = visual.color != null ? visual.color.getBlue() / 255.0F : 1;
//        double z = -90;
//
//        int width = mc.displayWidth;
//        int height = mc.displayHeight;
//
//        renderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
////        renderer.pos(0.0D, height, z).tex(0.0D, 1.0D).color(red, green, blue, 0.9f).endVertex();
////        renderer.pos(width, height, z).tex(1.0D, 1.0D).color(red, green, blue, 0.9f).endVertex();
////        renderer.pos(width, 0.0D, z).tex(1.0D, 0.0D).color(red, green, blue, 0.9f).endVertex();
////        renderer.pos(0.0D, 0.0D, z).tex(0.0D, 0.0D).color(red, green, blue, 0.9f).endVertex();
//        renderer.pos(0.0D, height, z).tex(0.0D, 1.0D).color(1f, 1f, 1f, 0.9f).endVertex();
//        renderer.pos(width, height, z).tex(1.0D, 1.0D).color(1f, 1f, 1f, 0.9f).endVertex();
//        renderer.pos(width, 0.0D, z).tex(1.0D, 0.0D).color(1f, 1f, 1f, 0.9f).endVertex();
//        renderer.pos(0.0D, 0.0D, z).tex(0.0D, 0.0D).color(1f, 1f, 1f, 0.9f).endVertex();
//        tessellator.draw();
//    }
//
////    private static void renderVisuals(Collection<Visual> visuals, TextureManager manager, int screenWidth, int screenHeight, float partialTicks) {
////        if (visuals == null || visuals.isEmpty())
////            return;
////        try {
//
////            for (Visual visual : visuals) {
////                if (visual.isVisible()) {
////                    GlStateManager.pushMatrix();
////                    visual.render(manager, screenWidth, screenHeight, partialTicks);
////                    GlStateManager.popMatrix();
////                }
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
