package com.ardium.pvp.common.blocks;

import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author - Yslohr on 04/03/2019
 */

public class BlockOreXP extends BlockOre {
    public BlockOreXP () {
        super ();
    }

    @Override
    public Item getItemDropped (int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return null;
    }

    @Override
    public int quantityDropped (Random p_149745_1_) {
        return 0;
    }

    @Override
    public int quantityDroppedWithBonus (int p_149679_1_, Random p_149679_2_) {
        return 0;
    }

    @Override
    public void dropBlockAsItemWithChance (World world, int x, int y, int z, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
        super.dropBlockAsItemWithChance (world, x, y, z, p_149690_5_, p_149690_6_, p_149690_7_);
    }

    @Override
    public int getExpDrop (IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
        return super.getExpDrop (p_149690_1_, p_149690_5_, p_149690_7_);
    }

    @Override
    public int damageDropped (int metadata) {
        return metadata;
    }
}