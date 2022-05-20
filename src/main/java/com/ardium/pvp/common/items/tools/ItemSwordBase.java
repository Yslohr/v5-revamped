package com.ardium.pvp.common.items.tools;

import com.ardium.pvp.Ardium;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWeb;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

/**
 * @author - Yslohr on 03/03/2019
 */

public class ItemSwordBase extends ItemSword {
    public ItemSwordBase (ToolMaterial toolMaterial) {
        super (toolMaterial);
        setCreativeTab (CreativeTabs.tabCombat);
    }

    @Override
    public float func_150893_a (ItemStack itemStack, Block block) {
        if (block instanceof BlockWeb) {
            return 15.0F;
        } else {
            Material material = block.getMaterial ();
            return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
        }
    }
}
