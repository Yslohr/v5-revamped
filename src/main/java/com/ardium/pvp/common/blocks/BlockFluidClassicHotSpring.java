package com.ardium.pvp.common.blocks;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.common.init.ArdiumFluids;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockFluidClassicHotSpring extends BlockFluidClassic {

    private IIcon stillIcon, flowingIcon;

    public BlockFluidClassicHotSpring() {
        super(ArdiumFluids.fluidWaterHotSpring, Material.water);
        disableStats();
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.displaceIfPossible(world, x, y, z);
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (entity instanceof EntityLivingBase && !world.isRemote) {
            EntityLivingBase entityLivingBase = ((EntityLivingBase) entity);
            if (!entityLivingBase.isEntityUndead()) {
                entityLivingBase.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 1, 1, false));
            } else {
                entityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.getId(), 1, 1, false));
            }
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon(Ardium.MOD_ID + ":" + ArdiumFluids.HOT_SPRING_FLUID_NAME + "_still");
        flowingIcon = register.registerIcon(Ardium.MOD_ID + ":" + ArdiumFluids.HOT_SPRING_FLUID_NAME + "_flow");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1) ? stillIcon : flowingIcon;
    }

}
