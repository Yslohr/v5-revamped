package com.ardium.pvp.common.items;

import com.ardium.pvp.common.blocks.BlockCustomSlab;
import com.ardium.pvp.common.init.ArdiumBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemBlockCustomSlab extends ItemBlock
{
    private final boolean isFullBlock;
    private final Block theHalfSlab;
    private final Block doubleSlab;

    public ItemBlockCustomSlab(Block block)
    {
        super(block);
        this.theHalfSlab = ArdiumBlocks.custom_slab;
        this.doubleSlab = ArdiumBlocks.double_custom_slab;
        if(block == ArdiumBlocks.double_custom_slab)
        {
            this.isFullBlock = true;
        }
        else
        {
            this.isFullBlock = false;
        }
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata)
    {
        return this.field_150939_a.getIcon(2, metadata);
    }

    public int getMetadata(int metadata)
    {
        return metadata;
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        return ((BlockCustomSlab)theHalfSlab).func_150002_b(stack.getItemDamage());
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10)
    {
        if(this.isFullBlock)
        {
            return super.onItemUse(stack, player, world, x, y, z, side, par8, par9, par10);
        }
        else if(stack.stackSize == 0)
        {
            return false;
        }
        else if(!player.canPlayerEdit(x, y, z, side, stack))
        {
            return false;
        }
        else
        {
            Block i1 = world.getBlock(x, y, z);
            int j1 = world.getBlockMetadata(x, y, z);
            int k1 = j1 & 7;
            boolean flag = (j1 & 8) != 0;

            if((side == 1 && !flag || side == 0 && flag) && i1 == this.theHalfSlab && k1 == stack.getItemDamage())
            {
                if(world.checkNoEntityCollision(this.doubleSlab.getCollisionBoundingBoxFromPool(world, x, y, z)) && world.setBlock(x, y, z, this.doubleSlab, k1, 3))
                {
                    world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.doubleSlab.stepSound.getStepResourcePath(), (this.doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, this.doubleSlab.stepSound.getPitch() * 0.8F);
                    --stack.stackSize;
                }
                return true;
            }
            else
            {
                return this.placeDoubleSlabFromTop(stack, player, world, x, y, z, side) || super.onItemUse(stack, player, world, x, y, z, side, par8, par9, par10);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean func_150936_a(World world, int x, int y, int z, int side, EntityPlayer player, ItemStack stack)
    {
        int i1 = x;
        int j1 = y;
        int k1 = z;
        Block id = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);
        int j2 = meta & 7;
        boolean flag = (meta & 8) != 0;

        if((side == 1 && !flag || side == 0 && flag) && id == this.theHalfSlab && j2 == stack.getItemDamage())
        {
            return true;
        }
        else
        {
            if(side == 0)
            {
                --y;
            }

            if(side == 1)
            {
                ++y;
            }

            if(side == 2)
            {
                --z;
            }

            if(side == 3)
            {
                ++z;
            }

            if(side == 4)
            {
                --x;
            }

            if(side == 5)
            {
                ++x;
            }

            id = world.getBlock(x, y, z);
            meta = world.getBlockMetadata(x, y, z);
            j2 = meta & 7;
            flag = (meta & 8) != 0;
            return id == this.theHalfSlab && j2 == stack.getItemDamage() || super.func_150936_a(world, i1, j1, k1, side, player, stack);
        }
    }

    private boolean placeDoubleSlabFromTop(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side)
    {
        if(side == 0)
        {
            --y;
        }

        if(side == 1)
        {
            ++y;
        }

        if(side == 2)
        {
            --z;
        }

        if(side == 3)
        {
            ++z;
        }

        if(side == 4)
        {
            --x;
        }

        if(side == 5)
        {
            ++x;
        }

        Block i1 = world.getBlock(x, y, z);
        int j1 = world.getBlockMetadata(x, y, z);
        int k1 = j1 & 7;

        if(i1 == this.theHalfSlab && k1 == stack.getItemDamage())
        {
            if(world.checkNoEntityCollision(this.doubleSlab.getCollisionBoundingBoxFromPool(world, x, y, z)) && world.setBlock(x, y, z, this.doubleSlab, k1, 3))
            {
                world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.doubleSlab.stepSound.getStepResourcePath(), (this.doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, this.doubleSlab.stepSound.getPitch() * 0.8F);
                --stack.stackSize;
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}