package com.ardium.pvp.common.blocks;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.common.init.ArdiumBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockCustomSlab extends BlockSlab {
    public static final String[] StepTypes = new String[] {"ardium", "diamond", "gold", "iron","emerald","obsidian"};

    public BlockCustomSlab(boolean isdouble, Material material)
    {
        super(isdouble, material);
        this.setCreativeTab(Ardium.TAB_ARDIUM);
        if(!this.field_150004_a)
        {
            this.setLightOpacity(0);
        }
        this.setHardness(2.0F);
        this.setResistance(10.0F);

    }

    @Override
    public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
        return super.getDamageValue(p_149643_1_, p_149643_2_, p_149643_3_, p_149643_4_);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        int k = metadata & 7;
        return k == 0 ? ArdiumBlocks.ardium_block.getBlockTextureFromSide(side) : k == 1 ? Blocks.diamond_block.getBlockTextureFromSide(side) : k == 2 ? Blocks.gold_block.getBlockTextureFromSide(side) : k == 3 ? Blocks.iron_block.getBlockTextureFromSide(side) : k == 4 ? Blocks.emerald_block.getBlockTextureFromSide(side) : Blocks.obsidian.getBlockTextureFromSide(side);
    }

    @SideOnly(Side.CLIENT)
    private static boolean func_150003_a(Block block)
    {
        return block == ArdiumBlocks.custom_slab;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return func_150003_a(this) ? Item.getItemFromBlock(ArdiumBlocks.custom_slab) : Item.getItemFromBlock(ArdiumBlocks.double_custom_slab);
    }

    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ArdiumBlocks.custom_slab);
    }

    protected ItemStack createStackedBlock(int metadata)
    {
        return new ItemStack(ArdiumBlocks.custom_slab, 2, metadata & 7);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        if(item != Item.getItemFromBlock(ArdiumBlocks.double_custom_slab))
        {
            for(int i = 0; i < StepTypes.length; i++)
            {
                list.add(new ItemStack(item, 1, i));
            }
        }
    }

    @Override
    public String func_150002_b(int metadata)
    {
        if(metadata < 0 || metadata >= StepTypes.length)
        {
            metadata = 0;
        }
        return super.getUnlocalizedName() + "." + StepTypes[metadata];
    }
}