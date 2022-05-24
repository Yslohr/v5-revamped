package com.ardium.pvp.common.init;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.common.blocks.*;
import com.ardium.pvp.common.items.itemblocks.ItemBlockArdiumStuff;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.FluidRegistry;

import static net.minecraft.block.Block.soundTypeMetal;
import static net.minecraft.block.Block.soundTypePiston;

/**
 * @author - Yslohr on 03/03/2019
 */

public class ArdiumBlocks {
    public static Block ardium_block, compressed_ardium_block,oxium_block;
    public static Block ardium_ore, oxium_ore, xp_ore;
    public static Block ardium_fence, oxium_fence;
    public static Block ardium_fence_gate, oxium_fence_gate;
    public static Block ardium_stairs, oxium_stairs;
    public static Block ardium_furnace, oxium_furnace;

    public static Block customBlockFluid;



    public static void initialization () {
        ardium_ore = new BlockOreMeltable ("pickaxe", 2).setHardness (5.0F).setResistance (10.0F).setStepSound (soundTypePiston).setBlockName ("oreArdium").setBlockTextureName (Ardium.MOD_ID + ":ardium_ore");
        ardium_block = new BlockCompressedBeaconable (MapColor.purpleColor, 2).setHardness (10.0F).setResistance (15.0F).setStepSound (soundTypeMetal).setBlockName ("blockArdium").setBlockTextureName (Ardium.MOD_ID + ":ardium_block");
        ardium_fence = new BlockFenceBase ("ardium_block", Material.iron, "pickaxe", 2).setBlockTextureName (Ardium.MOD_ID + ":ardium_block").setHardness (5.0F).setResistance (10.0F).setStepSound (soundTypeMetal).setBlockName ("ardiumFence");
        ardium_fence_gate = new BlockFenceGateBase (ardium_block, "pickaxe", 2).setHardness (10.0F).setResistance (15.0F).setStepSound (soundTypeMetal).setBlockName ("ardiumFenceGate");
        ardium_stairs = new BlockStairsBase (ardium_block, 0, "pickaxe", 2).setBlockName ("stairsArdiumBlock");
        xp_ore = new BlockOreXP ();

        //customBlockFluid = new BlockFluidCustom(ArdiumFluids.customFluid, Material.water).setBlockTextureName(Ardium.MOD_ID + ":customFluid");

        registerBlocks ();
    }

    private static void registerBlocks () {
        GameRegistry.registerBlock (ardium_ore, ItemBlockArdiumStuff.class, "ardium_ore");
        GameRegistry.registerBlock (ardium_block, ItemBlockArdiumStuff.class, "ardium_block");
        GameRegistry.registerBlock (ardium_fence, ItemBlockArdiumStuff.class, "ardium_fence");
        GameRegistry.registerBlock (ardium_fence_gate, ItemBlockArdiumStuff.class, "ardium_fence_gate");
        GameRegistry.registerBlock (ardium_stairs, ItemBlockArdiumStuff.class, "ardium_stairs");

        //GameRegistry.registerBlock(customBlockFluid, customBlockFluid.getUnlocalizedName().substring(5));
        //GameRegistry.registerBlock (customBlockFluid, "customFluid");
    }
}
