package com.ardium.pvp.common.init;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.common.blocks.*;
import com.ardium.pvp.common.items.ItemBlockCustomSlab;
import com.ardium.pvp.common.items.itemblocks.ItemBlockArdiumStuff;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import static net.minecraft.block.Block.soundTypeMetal;
import static net.minecraft.block.Block.soundTypePiston;

/**
 * @author - Yslohr on 03/03/2019
 */

public class ArdiumBlocks {
    public static Block ardium_block, compressed_ardium_block, oxium_block, test_block;
    public static Block ardium_ore, oxium_ore, xp_ore;
    public static Block ardium_fence, oxium_fence;
    public static Block ardium_fence_gate, oxium_fence_gate;
    public static Block ardium_stairs, oxium_stairs;
    public static Block ardium_furnace,ardium_lit_furnace, oxium_furnace;

    public static Block custom_slab, double_custom_slab;

    public static Block blockFluidClassicFakeWater, blockFluidClassicHotSpring;


    public static void initialization() {
        ardium_ore = new BlockOreMeltable("pickaxe", 2).setHardness(5.0F).setResistance(10.0F).setStepSound(soundTypePiston).setBlockName("oreArdium").setBlockTextureName(Ardium.MOD_ID + ":ardium_ore");
        ardium_block = new BlockCompressedBeaconable(MapColor.purpleColor, 2).setHardness(10.0F).setResistance(15.0F).setStepSound(soundTypeMetal).setBlockName("blockArdium").setBlockTextureName(Ardium.MOD_ID + ":ardium_block");
        ardium_fence = new BlockFenceBase("ardium_block", Material.iron, "pickaxe", 2).setBlockTextureName(Ardium.MOD_ID + ":ardium_block").setHardness(5.0F).setResistance(10.0F).setStepSound(soundTypeMetal).setBlockName("ardiumFence");
        ardium_fence_gate = new BlockFenceGateBase(ardium_block, "pickaxe", 2).setHardness(10.0F).setResistance(15.0F).setStepSound(soundTypeMetal).setBlockName("ardiumFenceGate");
        ardium_stairs = new BlockStairsBase(ardium_block, 0, "pickaxe", 2).setBlockName("stairsArdiumBlock");
        xp_ore = new BlockOreXP();

        ardium_furnace = new BlockCustomFurnace(false).setHardness(3.5F).setStepSound(soundTypePiston).setBlockName("customFurnace").setCreativeTab(Ardium.TAB_ARDIUM);
        ardium_lit_furnace = new BlockCustomFurnace(true).setHardness(3.5F).setStepSound(soundTypePiston).setBlockName("customFurnace").setLightLevel(0.875F);

        custom_slab = new BlockCustomSlab(false, Material.rock).setStepSound(soundTypePiston).setBlockName("customSlab");
        double_custom_slab = new BlockCustomSlab(true, Material.rock).setStepSound(soundTypePiston).setLightLevel(0.875F).setBlockName("customSlab");

        //test_block = new BlockStone().setHardness(50.0F).setResistance(2000.0F).setStepSound(soundTypePiston).setBlockName("testBlock").setBlockTextureName(Ardium.MOD_ID + ":test_block");
        blockFluidClassicFakeWater = new BlockFluidClassicFakeWater().setHardness(100F).setLightOpacity(3);
        blockFluidClassicHotSpring = new BlockFluidClassicHotSpring().setHardness(100F).setLightOpacity(3);

        registerBlocks();
    }

    private static void registerBlocks() {
        GameRegistry.registerBlock(ardium_ore, ItemBlockArdiumStuff.class, "ardium_ore");
        GameRegistry.registerBlock(ardium_block, ItemBlockArdiumStuff.class, "ardium_block");
        GameRegistry.registerBlock(ardium_fence, ItemBlockArdiumStuff.class, "ardium_fence");
        GameRegistry.registerBlock(ardium_fence_gate, ItemBlockArdiumStuff.class, "ardium_fence_gate");
        GameRegistry.registerBlock(ardium_stairs, ItemBlockArdiumStuff.class, "ardium_stairs");

        GameRegistry.registerBlock(ardium_furnace, "ardium_furnace");
        GameRegistry.registerBlock(ardium_lit_furnace, "ardium_lit_furnace");

//        GameRegistry.registerBlock(test_block, "testBlock");


        GameRegistry.registerBlock(custom_slab, ItemBlockCustomSlab.class, "custom_slab");
        GameRegistry.registerBlock(double_custom_slab, ItemBlockCustomSlab.class, "double_custom_slab");

        GameRegistry.registerBlock(blockFluidClassicFakeWater, ArdiumFluids.FAKE_WATER_FLUID_NAME);
        GameRegistry.registerBlock(blockFluidClassicHotSpring, ArdiumFluids.HOT_SPRING_FLUID_NAME);
    }
}
