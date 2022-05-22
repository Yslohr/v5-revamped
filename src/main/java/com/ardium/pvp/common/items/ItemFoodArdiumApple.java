package com.ardium.pvp.common.items;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.common.init.ArdiumItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFoodArdiumApple extends ItemFood {

    public ItemFoodArdiumApple(int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat) {
        super(healAmount, saturationModifier, isWolfsFavoriteMeat);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return stack != null && stack.getItem() != null && stack.getItem() == ArdiumItems.ardium_apple;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 1200, 4));
        player.addPotionEffect(new PotionEffect(Potion.heal.getId(), 1, 10));
        player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 2400, 0));
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 2400, 0));
        player.setAbsorptionAmount(5.0f);
    }
}
