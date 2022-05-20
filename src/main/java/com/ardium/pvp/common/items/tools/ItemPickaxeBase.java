package com.ardium.pvp.common.items.tools;

import com.ardium.pvp.Ardium;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

/**
 * @author - Yslohr on 03/03/2019
 */

public class ItemPickaxeBase extends ItemPickaxe {
    public ItemPickaxeBase (ToolMaterial toolMaterial) {
        super (toolMaterial);
        setCreativeTab (CreativeTabs.tabTools);
    }
}
