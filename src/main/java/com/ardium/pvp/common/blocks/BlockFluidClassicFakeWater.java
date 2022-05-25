package com.ardium.pvp.common.blocks;

import com.ardium.pvp.common.init.ArdiumFluids;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockFluidClassicFakeWater extends BlockFluidClassic {

    private IIcon stillIcon, flowIcon;

    public BlockFluidClassicFakeWater() {
        super(ArdiumFluids.fluidFakeWater, Material.water);
        setHardness(100F);
        setLightOpacity(3);
        disableStats();
    }

    @SubscribeEvent
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.displaceIfPossible(world, x, y, z);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (!(world.isRemote) && (entity instanceof EntityLivingBase)) {
            entity.attackEntityFrom(DamageSource.magic, 1.0F);
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon("minecraft:water_still");
        flowIcon = register.registerIcon("minecraft:water_flow");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1) ? stillIcon : flowIcon;
    }
}