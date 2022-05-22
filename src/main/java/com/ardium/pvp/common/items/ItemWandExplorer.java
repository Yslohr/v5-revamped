package com.ardium.pvp.common.items;


import com.ardium.pvp.common.items.utils.Radar;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ItemWandExplorer extends Item {

    public ItemWandExplorer() {

        this.setMaxStackSize(1);
        this.setMaxDamage(10);
    }

    @SubscribeEvent
    public void onWorldRender(final RenderWorldLastEvent ev) {
        if (Minecraft.getMinecraft().thePlayer.getHeldItem() != null && Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemWandExplorer && Minecraft.getMinecraft().theWorld.isRemote && Minecraft.getMinecraft().theWorld != null) {
            for (int i = 0; i < Minecraft.getMinecraft().theWorld.loadedTileEntityList.size(); ++i) {
                if (Minecraft.getMinecraft().theWorld.loadedTileEntityList.get(i) instanceof TileEntity) {
                    final TileEntity entity = (TileEntity) Minecraft.getMinecraft().theWorld.loadedTileEntityList.get(i);
                    double[] posPlayer = new double[]{Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ};
                    double[] posEntity = new double[]{entity.xCoord, entity.yCoord, entity.zCoord};
                    double distance = (posPlayer[0] - posEntity[0]) + (posPlayer[1] - posEntity[1]) + (posPlayer[2] - posEntity[2]);
                    if (entity instanceof IInventory && (distance <= 128 || distance >= -128)) {
                        Radar.drawTrappedChestESP(entity.xCoord - Minecraft.getMinecraft().thePlayer.lastTickPosX, entity.yCoord - Minecraft.getMinecraft().thePlayer.lastTickPosY, entity.zCoord - Minecraft.getMinecraft().thePlayer.lastTickPosZ);
                    }
                }
            }
        }
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

}
