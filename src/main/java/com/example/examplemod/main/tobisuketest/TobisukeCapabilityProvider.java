package com.example.examplemod.main.tobisuketest;

import com.example.examplemod.main.util.MyCapabilities;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

public class TobisukeCapabilityProvider implements ICapabilitySerializable<NBTBase>{
    @CapabilityInject(TobisukeCapabilities.class)
    public static final Capability<TobisukeCapabilities> TOBI_CAP = null;
    private TobisukeCapabilities instance = TOBI_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == TOBI_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == TOBI_CAP ? TOBI_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return TOBI_CAP.getStorage().writeNBT(TOBI_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        TOBI_CAP.getStorage().readNBT(TOBI_CAP, this.instance, null, nbt);
    }
}