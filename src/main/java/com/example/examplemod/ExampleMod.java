package com.example.examplemod;

import com.example.examplemod.hapyo.SleeplessPotion;
import com.example.examplemod.main.entry.*;
import com.example.examplemod.main.other.MyCreativeTab;
import com.example.examplemod.main.tobisuketest.TobisukeCapabilities;
import com.example.examplemod.main.util.MyCapabilities;
import com.example.examplemod.main.util.MyTickManager;
import com.example.examplemod.main.util.RenderMyHudEvent;
import com.example.examplemod.tests.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    public static BiomeManager.BiomeEntry myBiomeEntry = new BiomeManager.BiomeEntry(new MyBiome(), 30);
    public static BiomeManager.BiomeEntry myBiome2Entry = new BiomeManager.BiomeEntry(new MyBiome2(), 30);

    public static final boolean IS_TEST_ENABLED = true;

    public static CreativeTabs myCreativeTab = new MyCreativeTab("MyCreativeTab");

    @Mod.Instance(MODID)
    public static ExampleMod instance;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        boolean isClient = event.getSide().isClient();

        if(isClient){
            OBJLoader.INSTANCE.addDomain(MODID);
        }

        MyItems.init();
        MyItems.register(isClient);

        MyBlocks.init();
        MyBlocks.register(isClient);

        MySoundEvents.init();
        MySoundEvents.register();

        MyRecipes.register();

        MyEntities.register();

//        registerBiome();




        Organizer.init();


        Potion sleeplessPotion = new SleeplessPotion();
        GameRegistry.register(sleeplessPotion, new ResourceLocation(MODID, "sleepless"));
        PotionType sleeplessType = new PotionType("sleepless", new PotionEffect(sleeplessPotion));
        GameRegistry.register(sleeplessType, new ResourceLocation(MODID, "sleepless"));

        CapabilityManager.INSTANCE.register(MyCapabilities.class, new MyCapabilities.Storage(), MyCapabilities.MyCap.class);
        CapabilityManager.INSTANCE.register(TobisukeCapabilities.class, new TobisukeCapabilities.Storage(), TobisukeCapabilities.TobisukeCapability.class);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        MyEvents.register();
        MinecraftForge.EVENT_BUS.register(new RenderMyHudEvent());
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
        setValueToMyTickManager(() -> {
            setGuiUpdate();
        }, 500);
        setValueToMyTickManager(() -> {
            addSleepLessValue();
        }, 50);
    }

    void addSleepLessValue(){
        Organizer.sleeplessValue += 50;
        setValueToMyTickManager(() -> {
            addSleepLessValue();
        }, 50);
    }

    void setGuiUpdate(){
        Organizer.sleepCount = Math.round(Math.abs(100000 - Organizer.sleeplessValue) / 10000);
        if(Organizer.sleeplessValue > 100000){
            Organizer.taskToKill = true;
        }
        System.out.println(Organizer.sleeplessValue);
        setValueToMyTickManager(() -> {
            setGuiUpdate();
        }, 500);
    }

    void setValueToMyTickManager(Runnable runner, int delay){
        MyTickManager.runner.add(runner);
        MyTickManager.delay.add(delay);
        MyTickManager.delayCount.add(0);
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event){
        event.registerServerCommand(new MyCommand());
    }

    private void registerBiome(){
        GameRegistry.registerWorldGenerator(new MyWorldGenerator(MyBlocks.myBlock, 1000), 1);

        BiomeManager.oceanBiomes.clear();
        BiomeProvider.allowedBiomes.clear();

        Biome.registerBiome(40, "mybiome", myBiomeEntry.biome);
        BiomeManager.addSpawnBiome(myBiomeEntry.biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, myBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, myBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, myBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, myBiomeEntry);

        Biome.registerBiome(40, "mybiome2", myBiome2Entry.biome);
        BiomeManager.addSpawnBiome(myBiome2Entry.biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, myBiome2Entry);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, myBiome2Entry);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, myBiome2Entry);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, myBiome2Entry);
    }
}
