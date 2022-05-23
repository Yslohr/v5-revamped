package com.ardium.pvp.common.events;

import com.ardium.pvp.common.init.ArdiumBlocks;
import com.ardium.pvp.common.init.ArdiumItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.FillBucketEvent;

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
}
