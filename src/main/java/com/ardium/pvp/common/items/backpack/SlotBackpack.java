package com.ardium.pvp.common.items.backpack;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBackpack extends Slot
{
    public SlotBackpack(final IInventory inv, final int index, final int x, final int y) {
        super(inv, index, x, y);
    }

    public boolean isItemValid(final ItemStack stack) {
        return !(stack.getItem() instanceof ItemBackpack);
    }
}