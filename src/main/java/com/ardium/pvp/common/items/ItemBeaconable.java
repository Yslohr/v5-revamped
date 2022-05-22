package com.ardium.pvp.common.items;

import com.ardium.pvp.common.init.ArdiumItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

/**
 * @author - Yslohr on 03/03/2019
 */

public class ItemBeaconable extends Item {
    public ItemBeaconable () {
        setCreativeTab (CreativeTabs.tabMaterials);
    }

    public boolean isBeaconPayment (ItemStack stack) {
        return stack.getItem () instanceof ItemBeaconable;
    }

    @Override
    public String getItemStackDisplayName (ItemStack itemStack) {
        if (itemStack != null && itemStack.getItem () != null) {
            if (itemStack.getItem () == ArdiumItems.ardium_ingot) return EnumChatFormatting.DARK_PURPLE + super.getItemStackDisplayName (itemStack) + EnumChatFormatting.RESET;
            if (itemStack.getItem () == ArdiumItems.oxium_ingot) return EnumChatFormatting.GOLD + super.getItemStackDisplayName (itemStack) + EnumChatFormatting.RESET;
        }
        return ("" + StatCollector.translateToLocal (this.getUnlocalizedNameInefficiently (itemStack) + ".name")).trim ();
    }

}