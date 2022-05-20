package com.ardium.pvp.common.blocks;

import com.ardium.pvp.Ardium;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author - Yslohr on 04/03/2019
 */

public class BlockOreMeltable extends BlockOre {
    public BlockOreMeltable (String toolClass, int harvestLevel) {
        setCreativeTab (Ardium.TAB_ARDIUM);
        setHarvestLevel (toolClass, harvestLevel);
    }

    @Override
    public Item getItemDropped (int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock (this);
    }

    @Override
    public int quantityDropped (Random random) {
        return 1;
    }

    @Override
    public int quantityDroppedWithBonus (int p_149679_1_, Random random) {
        return this.quantityDropped (random);
    }

    @Override
    public int getExpDrop (IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
        return 0;
    }
}
