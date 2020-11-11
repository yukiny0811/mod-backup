package com.example.examplemod.main.util;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public interface MyCapabilities {
    void setSleepless(int sleepless);
    int getSleepless();

    class MyCap implements MyCapabilities{
        private int sleepless = 0;

        @Override
        public void setSleepless(int sleepless) {
            this.sleepless = sleepless;
        }

        @Override
        public int getSleepless() {
            return this.sleepless;
        }
    }

    class Storage implements Capability.IStorage<MyCapabilities>{
        @Override
        public NBTBase writeNBT(Capability<MyCapabilities> capability, MyCapabilities instance, EnumFacing side) {
            return new NBTTagInt(instance.getSleepless());
        }

        @Override
        public void readNBT(Capability<MyCapabilities> capability, MyCapabilities instance, EnumFacing side, NBTBase nbt) {
            instance.setSleepless(((NBTPrimitive)nbt).getInt());
        }
    }

}
