package com.ardium.pvp.common;

import com.ardium.pvp.common.events.EventHandlerArdium;
import com.ardium.pvp.common.init.ArdiumBlocks;
import com.ardium.pvp.common.init.ArdiumFluids;
import com.ardium.pvp.common.init.ArdiumItems;
import com.ardium.pvp.common.items.ItemWandExplorer;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * @author - Yslohr on 03/03/2019
 */

public class CommonProxy {
    public void preInitialization (FMLPreInitializationEvent preInitializationEvent) {
        ArdiumFluids.initialization ();
        ArdiumBlocks.initialization ();
        ArdiumItems.initialization ();
        ArdiumFluids.registerFluid ("customFluid", ArdiumItems.customFluidBucket);
    }

    public void initialization (FMLInitializationEvent initializationEvent) {
    }

    public void postInitialization (FMLPostInitializationEvent postInitializationEvent) {

        //MinecraftForge.EVENT_BUS.register (new EventHandlerArdium());
        MinecraftForge.EVENT_BUS.register(new ItemWandExplorer());
    }
}
