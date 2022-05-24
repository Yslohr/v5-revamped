package com.ardium.pvp.common.items.backpack;


import com.ardium.pvp.Ardium;
import javafx.scene.control.Tab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemBackpack extends Item
{
    public static final String NAME = "backpack";

    public ItemBackpack() {
        this.maxStackSize = 1;
    }

    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        if (!world.isRemote) {
            player.openGui(Ardium.instance,0, world, 0,0,0);

            final NBTTagCompound nbt = player.getHeldItem().getTagCompound();
            nbt.setBoolean("Open", true);
            return stack;
        }
        return stack;
    }

    public void onUpdate(final ItemStack stack, final World world, final Entity e, final int in, final boolean b) {
        if (stack.hasTagCompound() && stack.getTagCompound().hasKey("Open") && !b) {
            stack.getTagCompound().setBoolean("Open", false);
        }
        super.onUpdate(stack, world, e, in, b);
    }
}
