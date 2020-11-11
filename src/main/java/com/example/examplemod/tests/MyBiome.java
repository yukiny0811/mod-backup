package com.example.examplemod.tests;

import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomePlains;

public class MyBiome extends BiomePlains {
    private static BiomeProperties properties = new Biome.BiomeProperties("MyBiome")
            .setTemperature(1f)
            .setRainfall(1f)
            .setBaseHeight(-0.25f)
            .setHeightVariation(10.5f);
    public MyBiome(){
        super(false, properties);
        this.spawnableCaveCreatureList.add(new Biome.SpawnListEntry(EntityBlaze.class, 1000, 5, 5));

        theBiomeDecorator.treesPerChunk = 15;
        theBiomeDecorator.flowersPerChunk = 10;
    }
}
