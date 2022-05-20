package com.ardium.pvp.common.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

/**
 * @author - Yslohr on 03/03/2019
 */

public class ItemAxeBase extends ItemAxe {
    public ItemAxeBase (ToolMaterial toolMaterial) {
        super (toolMaterial);
        setCreativeTab (CreativeTabs.tabTools);
    }
}
