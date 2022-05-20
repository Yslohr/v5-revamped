package com.ardium.pvp.common.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.Arrays;
import java.util.List;

/**
 * @author - Yslohr on 04/03/2019
 */

public class ItemBlockArdiumStuff extends ItemBlock {
    public ItemBlockArdiumStuff (Block block) {
        super (block);
    }


    @Override
    public int getMetadata (int metadata) {
        return metadata;
    }

    @Override
    public String getUnlocalizedName (ItemStack stack) {
        int metadata = stack.getItemDamage ();
        if (metadata < 0) {
            metadata = 0;
        }
        return EnumChatFormatting.DARK_PURPLE + super.getUnlocalizedName ()+ EnumChatFormatting.RESET;
    }
}
