package com.ardium.pvp.common.items.backpack;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryBackpack implements IInventory
{
    public ItemStack[] content;
    public int size;

    public InventoryBackpack(final ItemStack container, int size) {
        this.size = size;
        this.content = new ItemStack[size];
        if (!container.hasTagCompound()) {
            container.setTagCompound(new NBTTagCompound());
        }
        this.readFromNBT(container.getTagCompound());
    }

    public void readFromNBT(final NBTTagCompound comp) {
        final NBTTagList nbtlist = comp.getTagList("Inventory", 10);
        for (int i = 0; i < nbtlist.tagCount(); ++i) {
            final NBTTagCompound comp2 = nbtlist.getCompoundTagAt(i);
            final int slot = comp2.getInteger("Slot");
            this.content[slot] = ItemStack.loadItemStackFromNBT(comp2);
        }
    }

    public void writeToNBT(final NBTTagCompound comp) {
        final NBTTagList nbtlist = new NBTTagList();
        for (int i = 0; i < this.size; ++i) {
            if (this.content[i] != null) {
                final NBTTagCompound comp2 = new NBTTagCompound();
                comp2.setInteger("Slot", i);
                this.content[i].writeToNBT(comp2);
                nbtlist.appendTag((NBTBase)comp2);
            }
        }
        comp.setTag("Inventory", (NBTBase)nbtlist);
    }

    public int getSizeInventory() {
        return this.size;
    }

    public ItemStack getStackInSlot(final int index) {
        return this.content[index];
    }

    public ItemStack decrStackSize(final int index, final int amount) {
        ItemStack stack = this.getStackInSlot(index);
        if (stack != null) {
            if (stack.stackSize > amount) {
                stack = stack.splitStack(amount);
                if (stack.stackSize == 0) {
                    this.content[index] = null;
                }
            }
            else {
                this.content[index] = null;
            }
        }
        return stack;
    }

    public ItemStack getStackInSlotOnClosing(final int index) {
        final ItemStack stack = this.getStackInSlot(index);
        if (stack != null) {
            this.content[index] = null;
        }
        return stack;
    }

    public void setInventorySlotContents(final int index, final ItemStack stack) {
        this.content[index] = stack;
    }

    public String getInventoryName() {
        return "ardium.container.backpack";
    }

    public boolean hasCustomInventoryName() {
        return false;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public void markDirty() {
    }

    public boolean isUseableByPlayer(final EntityPlayer player) {
        return true;
    }

    public void openInventory() {
    }

    public void closeInventory() {
    }

    public boolean isItemValidForSlot(final int index, final ItemStack stack) {
        return !(stack.getItem() instanceof ItemBackpack);
    }
}
