package com.example.examplemod.main.util;

import com.example.examplemod.main.entry.Organizer;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber
public class MyTickManager{
    public static List<Runnable> runner = new ArrayList<>();
    public static List<Integer> delay = new ArrayList<>();
    public static List<Integer> delayCount = new ArrayList<>();

    @SubscribeEvent
    public static void updateTick(TickEvent.WorldTickEvent event){
        for(int i = 0; i < delay.size(); i++){
            delayCount.set(i, delayCount.get(i) + 1);
            if(delayCount.get(i) > delay.get(i)){
                runner.get(i).run();
                runner.remove(i);
                delay.remove(i);
                delayCount.remove(i);
            }
        }
    }

    @SubscribeEvent
    public static void updateTick(TickEvent.PlayerTickEvent event){
        if(Organizer.taskToKill){
            Organizer.sleeplessValue = 100000;
            Organizer.sleepCount = 10;
            event.player.onKillCommand();
        }
    }

    public static List<Runnable> renderRunner = new ArrayList<>();
    public static List<Integer> renderDelay = new ArrayList<>();
    public static List<Integer> renderDelayCount = new ArrayList<>();

    public static boolean testBool = false;
    public static BlockPos eventBlockPos;

    public static double renderPartialTicks = 0;

    @SubscribeEvent
    public static void renderTick(RenderWorldLastEvent event){

        renderPartialTicks = event.getPartialTicks();
        for(int i = 0; i < renderDelay.size(); i++){
            renderDelayCount.set(i, renderDelayCount.get(i) + 1);
            if(renderDelayCount.get(i) > renderDelay.get(i)){
                renderRunner.get(i).run();
                renderRunner.remove(i);
                renderDelay.remove(i);
                renderDelayCount.remove(i);
            }
        }




    }

    private static void setValueToMyTickManager(Runnable runner, int delay){
        MyTickManager.renderRunner.add(runner);
        MyTickManager.renderDelay.add(delay);
        MyTickManager.renderDelayCount.add(0);
    }

    public static void test(){



        funct(0, eventBlockPos);

    }

    public static void funct(int depth, BlockPos position){

        setValueToMyTickManager(() -> {
            int x = position.getX();
            int y = position.getY();
            int z = position.getZ();
            BlockPos tempPos = new BlockPos(x, y, z);
            if(Minecraft.getMinecraft().getIntegratedServer().getEntityWorld().getBlockState(tempPos).getBlock() == Blocks.AIR && depth != 0){
                return;
            }
            Block blockb = Blocks.BEDROCK;
            IBlockState blockState = blockb.getDefaultState();
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            GlStateManager.disableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
            GL11.glLineWidth(2.5f);
            double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * MyTickManager.renderPartialTicks;
            double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * MyTickManager.renderPartialTicks;
            double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * MyTickManager.renderPartialTicks;
            AxisAlignedBB largeBB = blockState.getSelectedBoundingBox(Minecraft.getMinecraft().getIntegratedServer().getEntityWorld(), tempPos).expand(0.005, 0.005, 0.005).offset(-d0, -d1, -d2);
            World world = Minecraft.getMinecraft().getIntegratedServer().getEntityWorld();
            if(world.getBlockState(position).getBlock() != Blocks.WATER && world.getBlockState(position).getBlock() != Blocks.FLOWING_WATER){
                RenderGlobal.drawSelectionBoundingBox(largeBB, 1f, 0.3f, 0.3f, 1f);
            }

            BlockPos pos1 = new BlockPos(position.getX() + 1, position.getY(), position.getZ());
            BlockPos pos2 = new BlockPos(position.getX() - 1, position.getY(), position.getZ());
            BlockPos pos3 = new BlockPos(position.getX() , position.getY() + 1, position.getZ());
            BlockPos pos4 = new BlockPos(position.getX() , position.getY() - 1, position.getZ());
            BlockPos pos5 = new BlockPos(position.getX() , position.getY(), position.getZ() + 1);
            BlockPos pos6 = new BlockPos(position.getX() , position.getY(), position.getZ() - 1);

            BlockPos exPos1 = new BlockPos(position.getX() + 1, position.getY() + 1, position.getZ());
            BlockPos exPos2 = new BlockPos(position.getX(), position.getY() + 1, position.getZ() + 1);
            BlockPos exPos3 = new BlockPos(position.getX() + 1, position.getY() , position.getZ() + 1);
            BlockPos exPos4 = new BlockPos(position.getX() - 1, position.getY() - 1, position.getZ());
            BlockPos exPos5 = new BlockPos(position.getX() , position.getY() - 1, position.getZ()-1);
            BlockPos exPos6 = new BlockPos(position.getX() - 1, position.getY(), position.getZ()-1);
            BlockPos exPos7 = new BlockPos(position.getX() + 1, position.getY() - 1, position.getZ());
            BlockPos exPos8 = new BlockPos(position.getX() - 1, position.getY() + 1, position.getZ());
            BlockPos exPos9 = new BlockPos(position.getX() + 1, position.getY(), position.getZ() - 1);
            BlockPos exPos10 = new BlockPos(position.getX() - 1, position.getY() , position.getZ() + 1);
            BlockPos exPos11 = new BlockPos(position.getX() , position.getY() + 1, position.getZ() - 1);
            BlockPos exPos12 = new BlockPos(position.getX(), position.getY() - 1, position.getZ() + 1);

            BlockPos exPos13 = new BlockPos(position.getX() + 1, position.getY() + 1, position.getZ() + 1);
            BlockPos exPos14 = new BlockPos(position.getX() + 1, position.getY() + 1, position.getZ() - 1);
            BlockPos exPos15 = new BlockPos(position.getX() + 1, position.getY() - 1, position.getZ() + 1);
            BlockPos exPos16 = new BlockPos(position.getX() + 1, position.getY() - 1, position.getZ() - 1);
            BlockPos exPos17 = new BlockPos(position.getX() - 1, position.getY() + 1, position.getZ() + 1);
            BlockPos exPos18 = new BlockPos(position.getX() - 1, position.getY() + 1, position.getZ() - 1);
            BlockPos exPos19 = new BlockPos(position.getX() - 1, position.getY() - 1, position.getZ() + 1);
            BlockPos exPos20 = new BlockPos(position.getX() - 1, position.getY() - 1, position.getZ() - 1);




            if(world.getBlockState(pos1).getBlock() != Blocks.AIR && world.getBlockState(pos2).getBlock() != Blocks.AIR && world.getBlockState(pos3).getBlock() != Blocks.AIR
                    && world.getBlockState(pos4).getBlock() != Blocks.AIR && world.getBlockState(pos5).getBlock() != Blocks.AIR && world.getBlockState(pos6).getBlock() != Blocks.AIR
                    && world.getBlockState(exPos1).getBlock() != Blocks.AIR && world.getBlockState(exPos2).getBlock() != Blocks.AIR && world.getBlockState(exPos3).getBlock() != Blocks.AIR
                    && world.getBlockState(exPos4).getBlock() != Blocks.AIR && world.getBlockState(exPos5).getBlock() != Blocks.AIR && world.getBlockState(exPos6).getBlock() != Blocks.AIR
                    && world.getBlockState(exPos7).getBlock() != Blocks.AIR && world.getBlockState(exPos8).getBlock() != Blocks.AIR && world.getBlockState(exPos9).getBlock() != Blocks.AIR
                    && world.getBlockState(exPos10).getBlock() != Blocks.AIR && world.getBlockState(exPos11).getBlock() != Blocks.AIR && world.getBlockState(exPos12).getBlock() != Blocks.AIR
                    && world.getBlockState(exPos13).getBlock() != Blocks.AIR && world.getBlockState(exPos14).getBlock() != Blocks.AIR && world.getBlockState(exPos15).getBlock() != Blocks.AIR
                    && world.getBlockState(exPos16).getBlock() != Blocks.AIR && world.getBlockState(exPos17).getBlock() != Blocks.AIR && world.getBlockState(exPos18).getBlock() != Blocks.AIR
                    && world.getBlockState(exPos19).getBlock() != Blocks.AIR && world.getBlockState(exPos20).getBlock() != Blocks.AIR){
                return;
            }

            if(depth < 7){
                funct(depth + 1, pos1);
                funct(depth + 1, pos2);
                funct(depth + 1, pos3);
                funct(depth + 1, pos4);
                funct(depth + 1, pos6);
                funct(depth + 1, pos6);
            }
        }, 5);
    }



//    public static void test(){
//        System.out.println("skfjhskdfjh");
//        Block blockb = Blocks.BEDROCK;
//        IBlockState blockState = blockb.getDefaultState();
//
//        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
//
//
//        for(int v = 0; v < 5; v++){
//            for (int j = 0; j < 20; j++){
//                for(int k = 0; k < 20; k++){
//                    double theta1 = Math.PI * 2 / 10 * j;
//                    double theta2 = Math.PI * 2 / 10 * k;
//                    int x = eventBlockPos.getX() + (int)Math.floor(v * Math.sin(theta1) * Math.cos(theta2));
//                    int y = eventBlockPos.getY() + (int)Math.floor(v * Math.sin(theta1) * Math.sin(theta2));
//                    int z = eventBlockPos.getZ() + (int)Math.floor(v * Math.cos(theta1));
//
//                    setValueToMyTickManager(() -> {
//                        BlockPos tempPos = new BlockPos(x, y, z);
//                        if(Minecraft.getMinecraft().getIntegratedServer().getEntityWorld().getBlockState(tempPos).getBlock() == Blocks.AIR){
//                            return;
//                        }
////
//                        GlStateManager.disableTexture2D();
//                        GlStateManager.disableBlend();
//                        GlStateManager.depthMask(true);
//                        GL11.glLineWidth(2.5f);
//                        double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * MyTickManager.renderPartialTicks;
//                        double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * MyTickManager.renderPartialTicks;
//                        double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * MyTickManager.renderPartialTicks;
//                        AxisAlignedBB largeBB = blockState.getSelectedBoundingBox(Minecraft.getMinecraft().getIntegratedServer().getEntityWorld(), tempPos).expand(0.005, 0.005, 0.005).offset(-d0, -d1, -d2);
//                        RenderGlobal.drawSelectionBoundingBox(largeBB, 1f, 0.3f, 0.3f, 1f);
//                    }, v * 5);
//                }
//            }
//        }
//    }
}
