package com.ardium.pvp.common.gui;

import com.ardium.pvp.common.container.ContainerBackpack;
import com.ardium.pvp.common.items.backpack.InventoryBackpack;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiBackpack extends GuiContainer
{
    public static final ResourceLocation texture;
    protected InventoryBackpack inv;
    protected InventoryPlayer playerInv;
    public int rows;

    public GuiBackpack(final InventoryPlayer playerInv, final InventoryBackpack inv) {
        super((Container)new ContainerBackpack(playerInv, inv));
        this.playerInv = playerInv;
        this.inv = inv;
        this.allowUserInput = false;
        this.rows = inv.getSizeInventory() / 9;
        this.ySize = 114 + this.rows * 18;
    }

    protected void drawGuiContainerForegroundLayer(final int x, final int y) {
        this.fontRendererObj.drawString(I18n.format(this.inv.getInventoryName(), new Object[0]), 8, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInv.hasCustomInventoryName() ? this.playerInv.getInventoryName() : I18n.format(this.playerInv.getInventoryName(), new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(final float prt, final int x, final int y) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiBackpack.texture);
        final int k = (this.width - this.xSize) / 2;
        final int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.rows * 18 + 17);
        this.drawTexturedModalRect(k, l + this.rows * 18 + 17, 0, 126, this.xSize, 96);
    }

    static {
        texture = new ResourceLocation("textures/gui/container/generic_54.png");
    }
}

