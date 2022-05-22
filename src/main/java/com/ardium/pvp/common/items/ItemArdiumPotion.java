package com.ardium.pvp.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemArdiumPotion extends ItemFood {


    public ItemArdiumPotion(int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat) {
        super(healAmount, saturationModifier, isWolfsFavoriteMeat);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.drink;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 3000, 1));
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 6000, 0));
        player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
    }

}