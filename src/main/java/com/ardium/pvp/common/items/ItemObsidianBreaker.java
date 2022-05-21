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


    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {

        if (world.isRemote) {
            final MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);
            if (movingobjectposition == null) {
                return super.onItemRightClick(item, world, player);
            }
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                final int i = movingobjectposition.blockX;
                final int j = movingobjectposition.blockY;
                final int k = movingobjectposition.blockZ;
                if (!world.canMineBlock(player, i, j, k)) {
                    return super.onItemRightClick(item, world, player);
                }
                if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, item)) {
                    return super.onItemRightClick(item, world, player);
                }
                final Block block = world.getBlock(i, j, k);
                final int l = world.getBlockMetadata(i, j, k);
                if (block == Blocks.obsidian && l == 0) {
                    world.setBlockToAir(i, j, k);
                    item.damageItem(1, (EntityLivingBase)player);
                    return super.onItemRightClick(item, world, player);
                }
            }


        }


        return super.onItemRightClick(item, world, player);
    }
}
