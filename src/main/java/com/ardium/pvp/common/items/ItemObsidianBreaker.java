package com.ardium.pvp.common.items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemObsidianBreaker extends Item {

    public ItemObsidianBreaker() {
        this.setMaxStackSize(1);
        this.setMaxDamage(1);
    }

    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {

        final MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);
        if (movingobjectposition == null) {
            return par1ItemStack;
        }
        if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final int i = movingobjectposition.blockX;
            final int j = movingobjectposition.blockY;
            final int k = movingobjectposition.blockZ;
            if (!par2World.canMineBlock(par3EntityPlayer, i, j, k)) {
                return par1ItemStack;
            }
            if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack)) {
                return par1ItemStack;
            }
            final Block block = par2World.getBlock(i, j, k);
            final int l = par2World.getBlockMetadata(i, j, k);
            if (block == Blocks.obsidian && l == 0) {
                par2World.func_147480_a(i, j, k, true);
                par1ItemStack.damageItem(2, (EntityLivingBase)par3EntityPlayer);
            }
        }
        return par1ItemStack;
    }
}
