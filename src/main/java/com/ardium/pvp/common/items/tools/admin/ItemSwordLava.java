package com.ardium.pvp.common.items.tools.admin;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * @author - Yslohr on 03/03/2019
 */

public class ItemSwordLava extends ItemSword {
    public ItemSwordLava (ToolMaterial toolMaterial) {
        super (toolMaterial);
    }


    @Override
    public boolean hitEntity (ItemStack itemStack, EntityLivingBase entityLivingBase1, EntityLivingBase entityLivingBase2) {
        entityLivingBase1.setFire (8);

        return true;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    @Override
    public boolean onItemUse (ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (side == 0) {
            --y;
        }

        if (side == 1) {
            ++y;
        }

        if (side == 2) {
            --z;
        }

        if (side == 3) {
            ++z;
        }

        if (side == 4) {
            --x;
        }

        if (side == 5) {
            ++x;
        }

        if (!player.canPlayerEdit (x, y, z, side, itemStack)) {
            return false;
        }
        final Block block = world.getBlock (x, y, z);
        if (block == Blocks.air) {
            world.playSoundEffect (x + 0.5, y + 0.5, z + 0.5, "fire.ignite", 1.0f, ItemSwordLava.itemRand.nextFloat () * 0.4f + 0.8f);
            world.setBlock (x, y, z, ( Block ) Blocks.fire);
        }
        itemStack.damageItem (3, ( EntityLivingBase ) player);
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack itemStack, EntityPlayer player, List list, boolean bool) {
        list.add (EnumChatFormatting.GOLD + "Ignites entities");
        list.add (EnumChatFormatting.GOLD + "+Right-Click for F&S");
        list.add (EnumChatFormatting.RED + "-3 Duribility Per F&S");
        int damage = itemStack.getMaxDamage () - itemStack.getItemDamage ();
        list.add (EnumChatFormatting.GRAY + "Durability: " + damage);
    }
}
