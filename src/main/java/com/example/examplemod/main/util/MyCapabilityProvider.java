package com.example.examplemod.main.util;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

public class MyCapabilityProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(MyCapabilities.class)
    public static final Capability<MyCapabilities> MY_CAP = null;
    private MyCapabilities instance = MY_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == MY_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == MY_CAP ? MY_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return MY_CAP.getStorage().writeNBT(MY_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        MY_CAP.getStorage().readNBT(MY_CAP, this.instance, null, nbt);
    }
}
