package com.example.examplemod.tests;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenKamakura extends WorldGenerator {
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if(rand.nextInt(100) >= 10){
            return false;
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    int height = 63 + i;
                    worldIn.setBlockState(position.add(j, height, k), Blocks.SNOW.getDefaultState());
                }
            }
        }
        return false;
    }


}
