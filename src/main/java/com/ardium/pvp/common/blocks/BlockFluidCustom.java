package com.ardium.pvp.common.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidCustom extends BlockFluidClassic {
    public BlockFluidCustom(Fluid fluid, Material material) {
        super(fluid, material);
    }
}
