package com.ardium.pvp.common;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.common.events.EventHandlerArdium;
import com.ardium.pvp.common.gui.ArdiumGuiHandler;
import com.ardium.pvp.common.init.ArdiumBlocks;
import com.ardium.pvp.common.init.ArdiumFluids;
import com.ardium.pvp.common.init.ArdiumItems;
import com.ardium.pvp.common.items.ItemWandExplorer;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author - Yslohr on 03/03/2019
 */

public class CommonProxy {
    public void preInitialization(FMLPreInitializationEvent preInitializationEvent) {
        ArdiumFluids.initialization();
        ArdiumBlocks.initialization();
        ArdiumItems.initialization();
        ArdiumFluids.registerFluid(ArdiumFluids.FAKE_WATER_FLUID_NAME, ArdiumItems.bucketFakeWater);
        ArdiumFluids.registerFluid(ArdiumFluids.HOT_SPRING_FLUID_NAME, ArdiumItems.bucketHotSpringWater);
    }

    public void initialization(FMLInitializationEvent initializationEvent) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Ardium.instance, new ArdiumGuiHandler());
    }

    public void postInitialization(FMLPostInitializationEvent postInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new EventHandlerArdium());
        MinecraftForge.EVENT_BUS.register(new ItemWandExplorer());
    }
}
