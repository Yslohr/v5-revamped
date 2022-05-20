package com.ardium.pvp.common.blocks;

import com.ardium.pvp.Ardium;
import net.minecraft.block.BlockCompressed;
import net.minecraft.block.material.MapColor;
import net.minecraft.world.IBlockAccess;

/**
 * @author - Yslohr on 04/03/2019
 */

public class BlockCompressedBeaconable extends BlockCompressed {
    public BlockCompressedBeaconable (MapColor mapColor, int harvestLevel) {
        super (mapColor);
        setCreativeTab (Ardium.TAB_ARDIUM);
        setHarvestLevel ("pickaxe", harvestLevel);
    }

    @Override
    public boolean isBeaconBase (IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
        return worldObj.getBlock (x, y, z) instanceof BlockCompressed;
    }
}
