package com.example.examplemod.main.tobisuketest;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public interface TobisukeCapabilities {

    void setItemName(String itemName);
    String getItemName();

    class TobisukeCapability implements TobisukeCapabilities{
        private String itemName = "nullitem";

        @Override
        public String getItemName() {
            return this.itemName;
        }

        @Override
        public void setItemName(String itemName) {
            this.itemName = itemName;
        }
    }

    class Storage implements Capability.IStorage<TobisukeCapabilities>{
        @Override
        public NBTBase writeNBT(Capability<TobisukeCapabilities> capability, TobisukeCapabilities instance, EnumFacing side) {
            return new NBTTagString(instance.getItemName());
        }

        @Override
        public void readNBT(Capability<TobisukeCapabilities> capability, TobisukeCapabilities instance, EnumFacing side, NBTBase nbt) {
            instance.setItemName(nbt.toString()); //???
        }
    }
}
