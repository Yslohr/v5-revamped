package com.ardium.pvp;

import com.ardium.pvp.common.CommonProxy;
import com.ardium.pvp.common.creativetabs.TabArdium;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;

import java.util.logging.Logger;

/**
 * @author - Yslohr on 03/03/2019
 */

@Mod (modid = Ardium.MOD_ID, name = "Ardium", version = "V5-Revamped", acceptedMinecraftVersions = "[1.7.10]")
public class Ardium {
    public static final String MOD_ID = "ardium";
    public static final CreativeTabs TAB_ARDIUM = new TabArdium ("ardiumTab");
    @Mod.Instance(value = Ardium.MOD_ID)
    public static Ardium instance;
    @SidedProxy(modId = MOD_ID, clientSide = "com.ardium.pvp.client.ClientProxy", serverSide = "com.ardium.pvp.common.CommonProxy")
    public static CommonProxy commonProxy;

    public static Logger logger = Logger.getLogger("ARDIUM");

    @Mod.EventHandler
    public void preInitialization (final FMLPreInitializationEvent preInitializationEvent) {
        commonProxy.preInitialization (preInitializationEvent);
    }

    @Mod.EventHandler
    public void initialization (final FMLInitializationEvent initializationEvent) {
        commonProxy.initialization (initializationEvent);
    }

    @Mod.EventHandler
    public void postInitialization (final FMLPostInitializationEvent postInitializationEvent) {
        commonProxy.postInitialization (postInitializationEvent);
    }
}
