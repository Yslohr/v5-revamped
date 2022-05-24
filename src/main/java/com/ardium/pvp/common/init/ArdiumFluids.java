package com.ardium.pvp.common.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * @author - Yslohr on 03/03/2019
 */

public class ArdiumFluids {

    public static Fluid customFluid;


    public static void initialization () {
        
        customFluid = new Fluid("customFluid").setDensity(4000).setViscosity(500).setTemperature(286).setLuminosity(10).setUnlocalizedName("customFluid");
        customFluid = FluidRegistry.getFluid("customFluid");

    }

    public static void registerFluid(String fluidName, Item bucketOfCustomFluid){
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(fluidName, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack (bucketOfCustomFluid), FluidContainerRegistry.EMPTY_BUCKET);

    }
}
