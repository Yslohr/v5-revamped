package com.ardium.pvp.common.events;

import com.ardium.pvp.common.init.ArdiumBlocks;
import com.ardium.pvp.common.init.ArdiumItems;
import com.ardium.pvp.common.items.tools.admin.ItemSwordLava;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.Random;

/**
 * @author - Yslohr on 03/03/2019
 */

public class EventHandlerArdium {
    /*
    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event)
    {
        Block id = event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);
        int metadata = event.world.getBlockMetadata(event.target.blockX, event.target.blockY, event.target.blockZ);
        if(id == ArdiumBlocks.customBlockFluid && metadata == 0)
        {
            event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
            if (!event.world.isRemote){
                event.entityPlayer.inventory.consumeInventoryItem(Items.bucket);
                EntityItem itemsc = new EntityItem(event.world, event.entityPlayer.posX, event.entityPlayer.posY, event.entityPlayer.posZ, new ItemStack(ArdiumItems.customFluidBucket, 1));
                event.world.spawnEntityInWorld(itemsc);
            }
        }
    }

     */

    @SubscribeEvent
    public void onPlayerInterract(PlayerInteractEvent e) {
        EntityPlayer player = e.entityPlayer;
        Block b = e.world.getBlock(e.x,e.y,e.z);
        //System.out.println(entity);

        if (!(b instanceof BlockTNT) || player.getHeldItem() == null || !(player.getHeldItem().getItem() instanceof ItemSwordLava) || e.action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        BlockTNT tnt = (BlockTNT) b;
        e.world.setBlockToAir(e.x,e.y,e.z);
        tnt.func_150114_a(e.world,e.x,e.y,e.z,1,player);
    }

    @SubscribeEvent
    public void onEntityInterract(EntityInteractEvent e) {
        Entity entity = e.target;
        EntityPlayer player = e.entityPlayer;
        Random rand =  new Random();

        System.out.println(entity);
        if (!(entity instanceof EntityCreeper) || player.getHeldItem() == null || !(player.getHeldItem().getItem() instanceof ItemSwordLava)) {
            return;
        }

        EntityCreeper creeper = (EntityCreeper) entity;
        creeper.worldObj.playSoundEffect(creeper.posX + 0.5D, creeper.posY + 0.5D, creeper.posZ + 0.5D, "fire.ignite", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
        player.swingItem();
        if (!creeper.worldObj.isRemote)
        {
            creeper.func_146079_cb();
            player.getHeldItem().damageItem(1, player);
        }



    }
}
