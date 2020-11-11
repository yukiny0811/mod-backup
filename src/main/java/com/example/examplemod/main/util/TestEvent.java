package com.example.examplemod.main.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import static com.example.examplemod.main.util.MyTickManager.eventBlockPos;

public class TestEvent implements RenderTickManagement{

    @SubscribeEvent
    public void blockHighlightEvent(DrawBlockHighlightEvent event){
        if(event.getTarget() != null && event.getTarget().typeOfHit == RayTraceResult.Type.BLOCK){
            IBlockState state = event.getPlayer().getEntityWorld().getBlockState(event.getTarget().getBlockPos());
            GlStateManager.disableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
            GL11.glLineWidth(2.5f);
            EntityPlayer player = event.getPlayer();
            double partialTicks = event.getPartialTicks();
            double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * partialTicks;
            double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * partialTicks;
            double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partialTicks;

            Block blockb = Blocks.BEDROCK;
            IBlockState blockState = blockb.getDefaultState();
//            AxisAlignedBB largeBB = blockState.getSelectedBoundingBox(player.getEntityWorld(), event.getTarget().getBlockPos()).expand(-0.005, -0.005, -0.005);
            AxisAlignedBB largeBB = blockState.getSelectedBoundingBox(player.getEntityWorld(), event.getTarget().getBlockPos()).expand(0.005, 0.005, 0.005).offset(-d0, -d1, -d2);
            RenderGlobal.drawSelectionBoundingBox(largeBB, 1f, 0.3f, 0.3f, 1f);

        }
    }

    @SubscribeEvent
    public void breakBlock(BlockEvent.BreakEvent event){
        System.out.println("s1");
//        if(!event.getWorld().isRemote){
//            return;
//        }
        System.out.println("s2");
        if(event.getPlayer() == null){
            return;
        }
        System.out.println("s3");
        if(event.getState().getBlock() != Blocks.GOLD_BLOCK){
            return;
        }
        System.out.println("s4");
        IBlockState state = event.getState();
        BlockPos pos = event.getPos();

        eventBlockPos = event.getPos();
//        MyTickManager.testBool = true;

        MyTickManager.test();


//        setValue();
    }

    private void setValue(){




//        Block blockb = Blocks.BEDROCK;
//        IBlockState blockState = blockb.getDefaultState();
//
//        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
//
////        double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * partialTicks;
////        double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * partialTicks;
////        double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partialTicks;
//
//        for(int i = 0; i < 10; i++){
//            for (int j = 0; j < 100; j++){
//                for(int k = 0; k < 100; k++){
//                    double theta1 = Math.PI * 2 / 100 * j;
//                    double theta2 = Math.PI * 2 / 100 * k;
//                    int x = (int)Math.floor(i * Math.sin(theta1) * Math.cos(theta2));
//                    int y = (int)Math.floor(i * Math.sin(theta1) * Math.sin(theta2));
//                    int z = (int)Math.floor(i * Math.cos(theta1));
//                    BlockPos tempPos = new BlockPos(x, y, z);
//                    setValueToMyTickManager(() -> {
////                        AxisAlignedBB largeBB = blockState.getSelectedBoundingBox(Minecraft.getMinecraft().thePlayer.getEntityWorld(), tempPos). expand(0.005, 0.005, 0.005).offset(-d0, -d1, -d2);
//                        AxisAlignedBB largeBB = blockState.getSelectedBoundingBox(Minecraft.getMinecraft().thePlayer.getEntityWorld(), tempPos).expand(0.005, 0.005, 0.005);
//                        RenderGlobal.drawSelectionBoundingBox(largeBB, 1f, 0.3f, 0.3f, 1f);
//                    }, 5);
//                }
//            }
//        }
    }

}
