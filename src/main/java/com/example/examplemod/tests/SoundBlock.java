package com.example.examplemod.tests;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.main.entry.MySoundEvents;
import com.example.examplemod.main.entry.Organizer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class SoundBlock extends Block {

    private static final PropertyInteger SOUND = PropertyInteger.create("sound", 0, 2);

    public SoundBlock(){
        super(Material.ROCK);
        setHardness(30);
        setCreativeTab(ExampleMod.myCreativeTab);
        setRegistryName("soundblock");
        setUnlocalizedName(ExampleMod.MODID + "_soundblock");
        setDefaultState(this.getBlockState().getBaseState().withProperty(SOUND, 0));
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        if(playerIn == null){
            return;
        }
        if(playerIn.getHeldItemMainhand() == null){
            return;
        }
        Item item = playerIn.getHeldItemMainhand().getItem();
        if(item != Items.STICK){
            return;
        }

        IBlockState blockState = worldIn.getBlockState(pos);
        int sound = blockState.getValue(SOUND);

        worldIn.playSound(playerIn, pos, Organizer.soundEvents_A[sound], SoundCategory.RECORDS, 1f, 1f);

        if(!worldIn.isRemote){
            String soundNumber = Integer.toString(sound + 1);
            playerIn.addChatComponentMessage(new TextComponentString(soundNumber + "番目の曲を再生中です"));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(SOUND, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(SOUND);
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, SOUND);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        IBlockState blockState = worldIn.getBlockState(pos);
        int sound = blockState.getValue(SOUND);

        sound += 1;

        if(sound >= 3){
            sound = 0;
        }

        worldIn.setBlockState(pos, blockState.withProperty(SOUND, sound));

        if(!worldIn.isRemote){
            String soundNumber = Integer.toString(sound + 1);
            playerIn.addChatComponentMessage(new TextComponentString(soundNumber + "番目の曲に変更しました"));
        }

        return true;
    }
}
