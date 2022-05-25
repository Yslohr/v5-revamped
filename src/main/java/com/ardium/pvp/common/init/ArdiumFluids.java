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

    public static final String HOT_SPRING_FLUID_NAME = "hot_spring_water";
    public static final String FAKE_WATER_FLUID_NAME = "fake_water";
    public static Fluid fluidWaterHotSpring,fluidFakeWater;


    public static void initialization() {
        fluidWaterHotSpring = new Fluid(HOT_SPRING_FLUID_NAME);
        if (!FluidRegistry.registerFluid(fluidWaterHotSpring)) {
            fluidWaterHotSpring = FluidRegistry.getFluid(ArdiumFluids.HOT_SPRING_FLUID_NAME);
        }

        fluidFakeWater = new Fluid(FAKE_WATER_FLUID_NAME);
        if (!FluidRegistry.registerFluid(fluidFakeWater)) {
            fluidFakeWater = FluidRegistry.getFluid(ArdiumFluids.FAKE_WATER_FLUID_NAME);
        }

    }

    public static void registerFluid(String fluidName, Item bucketOfCustomFluid) {
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(fluidName, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketOfCustomFluid), FluidContainerRegistry.EMPTY_BUCKET);
    }
}
