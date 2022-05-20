package com.ardium.pvp.common.blocks;

import com.ardium.pvp.Ardium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

/**
 * @author - Yslohr on 04/03/2019
 */

public class BlockFenceGateBase extends BlockFenceGate {
    private Block block;

    public BlockFenceGateBase (Block block, String toolClass, int harvestLevel) {
        this.block = block;
        setCreativeTab (Ardium.TAB_ARDIUM);
        setHarvestLevel (toolClass, harvestLevel);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int metadata) {
        return this.block.getBlockTextureFromSide (side);
    }


    @Override
    public Material getMaterial () {
        if (block != null) return this.block.getMaterial ();
        return super.getMaterial ();
    }
}
