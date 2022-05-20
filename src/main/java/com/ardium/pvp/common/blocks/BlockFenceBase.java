package com.ardium.pvp.common.blocks;

import com.ardium.pvp.Ardium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;

/**
 * @author - Yslohr on 04/03/2019
 */

public class BlockFenceBase extends BlockFence {
    private String iconName;

    public BlockFenceBase (String iconName, Material material, String toolClass, int harvestLevel) {
        super (iconName, material);
        this.iconName = iconName;
        setCreativeTab (Ardium.TAB_ARDIUM);
        setHarvestLevel (toolClass, harvestLevel);
    }

    /**
     * Returns true if the specified block can be connected by a fence
     */
    @Override
    public boolean canConnectFenceTo (IBlockAccess blockAccess, int x, int y, int z) {
        Block block = blockAccess.getBlock (x, y, z);
        return block == this || block instanceof BlockFenceGate || ((block.getMaterial ().isOpaque () && block.renderAsNormalBlock ()) && block.getMaterial () != Material.gourd);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons (IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon (Ardium.MOD_ID + ":" + this.iconName);
    }
}
