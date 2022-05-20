package com.ardium.pvp.common.blocks;

import com.ardium.pvp.Ardium;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

/**
 * @author - Yslohr on 04/03/2019
 */

public class BlockStairsBase extends BlockStairs {

    public BlockStairsBase (Block block, int metadata, String toolClass, int harvestLevel) {
        super (block, metadata);
        setCreativeTab (Ardium.TAB_ARDIUM);
        setHarvestLevel (toolClass, harvestLevel);
    }
}
