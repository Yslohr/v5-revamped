package com.ardium.pvp.common.items.backpack;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerBackpack extends Container
{
    int sizeInvBackpack;
    InventoryBackpack inventoryBackpack;

    public ContainerBackpack(final InventoryPlayer paramInventoryPlayer, final InventoryBackpack paramInventoryBackpack) {
        this.inventoryBackpack = paramInventoryBackpack;
        this.sizeInvBackpack = paramInventoryBackpack.getSizeInventory() / 9;
        for (int i = 0; i < this.sizeInvBackpack; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer((Slot)new SlotBackpack((IInventory)paramInventoryBackpack, j + i * 9, 8 + j * 18, 18 + i * 18));
            }
        }
        this.a(paramInventoryPlayer);
    }

    private void a(final InventoryPlayer paramInventoryPlayer) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot((IInventory)paramInventoryPlayer, j + i * 9 + 9, 8 + j * 18, 140 + i * 18));
            }
            for (i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot((IInventory)paramInventoryPlayer, i, 8 + i * 18, 198));
            }
        }
    }

    public void writeToNBT(final ItemStack paramItemStack) {
        if (paramItemStack == null) {
            return;
        }
        if (paramItemStack.getItem() == null) {
            return;
        }
        if (!(paramItemStack.getItem() instanceof ItemBackpack)) {
            return;
        }
        if (!paramItemStack.hasTagCompound()) {
            paramItemStack.setTagCompound(new NBTTagCompound());
        }
        this.inventoryBackpack.writeToNBT(paramItemStack.getTagCompound());
    }

    public boolean canInteractWith(final EntityPlayer paramEntityPlayer) {
        this.writeToNBT(paramEntityPlayer.getHeldItem());
        if (paramEntityPlayer.getHeldItem() == null || !(paramEntityPlayer.getHeldItem().getItem() instanceof ItemBackpack)) {
            paramEntityPlayer.closeScreen();
        }
        return true;
    }

    public void onContainerClosed(final EntityPlayer paramEntityPlayer) {
        this.writeToNBT(paramEntityPlayer.getHeldItem());
        super.onContainerClosed(paramEntityPlayer);
    }

    protected boolean mergeItemStack(final ItemStack paramItemStack, final int paramInt1, final int paramInt2, final boolean paramBoolean) {
        return super.mergeItemStack(paramItemStack, paramInt1, paramInt2, paramBoolean);
    }

    public ItemStack transferStackInSlot(final EntityPlayer paramEntityPlayer, final int paramInt) {
        ItemStack localItemStack1 = null;
        final Slot localSlot = (Slot) this.inventorySlots.get(paramInt);
        if (localSlot != null && localSlot.getHasStack()) {
            final ItemStack localItemStack2 = localSlot.getStack();
            localItemStack1 = localItemStack2.copy();
            if (localItemStack1.getItem() instanceof ItemBackpack) {
                this.writeToNBT(paramEntityPlayer.getHeldItem());
                return null;
            }
            if (paramInt < this.inventoryBackpack.getSizeInventory()) {
                if (!this.mergeItemStack(localItemStack2, this.inventoryBackpack.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(localItemStack2, 0, this.inventoryBackpack.getSizeInventory(), false)) {
                return null;
            }
            if (localItemStack2.stackSize == 0) {
                localSlot.putStack((ItemStack)null);
            }
            else {
                localSlot.onSlotChanged();
            }
        }
        this.writeToNBT(paramEntityPlayer.getHeldItem());
        return localItemStack1;
    }

    public ItemStack slotClick(final int paramInt1, final int paramInt2, final int paramInt3, final EntityPlayer paramEntityPlayer) {
        this.writeToNBT(paramEntityPlayer.getHeldItem());
        if (paramInt3 == 2 && paramInt2 == paramEntityPlayer.inventory.currentItem) {
            return null;
        }
        if (paramInt1 - this.inventoryBackpack.getSizeInventory() - 27 == paramEntityPlayer.inventory.currentItem) {
            return null;
        }
        return super.slotClick(paramInt1, paramInt2, paramInt3, paramEntityPlayer);
    }
}

