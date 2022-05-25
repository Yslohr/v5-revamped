package com.ardium.pvp.common.events;

import com.ardium.pvp.common.blocks.BlockFluidClassicFakeWater;
import com.ardium.pvp.common.blocks.BlockFluidClassicHotSpring;
import com.ardium.pvp.common.init.ArdiumItems;
import com.ardium.pvp.common.items.tools.admin.ItemSwordLava;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.Random;

/**
 * @author - Yslohr on 03/03/2019
 */

public class EventHandlerArdium {

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event) {
        Block block = event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);
        int metadata = event.world.getBlockMetadata(event.target.blockX, event.target.blockY, event.target.blockZ);
        if (block instanceof BlockFluidClassicHotSpring && metadata == 0) {
            event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
            if (!event.world.isRemote) {
                event.entityPlayer.inventory.consumeInventoryItem(Items.bucket);
                EntityItem entityItem = new EntityItem(event.world, event.entityPlayer.posX, event.entityPlayer.posY, event.entityPlayer.posZ, new ItemStack(ArdiumItems.bucketHotSpringWater, 1));
                event.world.spawnEntityInWorld(entityItem);
            }
        }
        if (block instanceof BlockFluidClassicFakeWater && metadata == 0) {
            event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
            if (!event.world.isRemote) {
                event.entityPlayer.inventory.consumeInventoryItem(Items.bucket);
                EntityItem entityItemBucket = new EntityItem(event.world, event.entityPlayer.posX, event.entityPlayer.posY, event.entityPlayer.posZ, new ItemStack(ArdiumItems.bucketFakeWater, 1));
                event.world.spawnEntityInWorld(entityItemBucket);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerInterract(PlayerInteractEvent event) {
        EntityPlayer player = event.entityPlayer;
        Block block = event.world.getBlock(event.x, event.y, event.z);

        if (!(block instanceof BlockTNT)
                || player.getHeldItem() == null
                || !(player.getHeldItem().getItem() instanceof ItemSwordLava)
                || event.action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        BlockTNT tnt = (BlockTNT) block;
        event.world.setBlockToAir(event.x, event.y, event.z);
        tnt.func_150114_a(event.world, event.x, event.y, event.z, 1, player);
        if (!player.capabilities.isCreativeMode) player.getHeldItem().damageItem(3, player);
    }

    @SubscribeEvent
    public void onEntityInterract(EntityInteractEvent event) {
        Entity entity = event.target;
        EntityPlayer player = event.entityPlayer;
        Random rand = new Random();
        if (!(entity instanceof EntityCreeper) || player.getHeldItem() == null || !(player.getHeldItem().getItem() instanceof ItemSwordLava)) {
            return;
        }

        EntityCreeper creeper = (EntityCreeper) entity;
        creeper.worldObj.playSoundEffect(creeper.posX + 0.5D, creeper.posY + 0.5D, creeper.posZ + 0.5D, "fire.ignite", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
        player.swingItem();
        if (!creeper.worldObj.isRemote) {
            creeper.func_146079_cb();
            player.getHeldItem().damageItem(3, player);
        }
    }

}
