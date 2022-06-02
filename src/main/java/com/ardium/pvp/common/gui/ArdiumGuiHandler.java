package com.ardium.pvp.common.gui;

import com.ardium.pvp.common.container.ContainerBackpack;
import com.ardium.pvp.common.container.ContainerCustomFurnace;
import com.ardium.pvp.common.items.backpack.InventoryBackpack;
import com.ardium.pvp.common.items.backpack.ItemBackpack;
import com.ardium.pvp.common.tileentity.TileEntityCustomFurnace;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ArdiumGuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        switch (ID) {
            case 0:
                // The last parameter must be a multiple of 9 (e.g: 9, 18, 27, 54)
                // Condition to check if the player has the right item in hand
                if (player.getHeldItem() == null || !(player.getHeldItem().getItem() instanceof ItemBackpack)) return null;
                return new ContainerBackpack(player.inventory, new InventoryBackpack(player.getHeldItem(), 54));
            /*
            case 1:
                return new ContainerCustomFurnace(player.inventory, new TileEntityCustomFurnace());
             */
        }
        if(tile_entity instanceof TileEntityCustomFurnace){
            return new ContainerCustomFurnace(player.inventory, (TileEntityCustomFurnace) tile_entity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        switch (ID) {
            case 0:
                // The last parameter must be a multiple of 9 (e.g: 9, 18, 27, 54)
                // Condition to check if the player has the right item in hand
                if (player.getHeldItem() == null || !(player.getHeldItem().getItem() instanceof ItemBackpack)) return null;
                return new GuiBackpack(player.inventory, new InventoryBackpack(player.getHeldItem(), 54));
            /*
            case 1:

                return new GuiCustomFurnace(player.inventory, new TileEntityCustomFurnace());
            */

        }
        if(tile_entity instanceof TileEntityCustomFurnace){
            return new GuiCustomFurnace(player.inventory, (TileEntityCustomFurnace) tile_entity);
        }

        return null;
    }
}
