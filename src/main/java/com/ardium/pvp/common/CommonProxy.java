package com.ardium.pvp.common;

import com.ardium.pvp.common.init.ArdiumBlocks;
import com.ardium.pvp.common.init.ArdiumFluids;
import com.ardium.pvp.common.init.ArdiumItems;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author - Yslohr on 03/03/2019
 */

public class CommonProxy {
    public void preInitialization (FMLPreInitializationEvent preInitializationEvent) {
        //ArdiumFluids.initialization ();
        ArdiumBlocks.initialization ();
        ArdiumItems.initialization ();
        //ArdiumFluids.registerFluid ("fake_water", ArdiumItems.fake_water_bucket);
    }

    public void initialization (FMLInitializationEvent initializationEvent) {
    }

    public void postInitialization (FMLPostInitializationEvent postInitializationEvent) {
        //MinecraftForge.EVENT_BUS.register (new EventHandlerArdium ());
    }
}
