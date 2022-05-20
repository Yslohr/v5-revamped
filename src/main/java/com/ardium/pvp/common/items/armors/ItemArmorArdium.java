package com.ardium.pvp.common.items.armors;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.common.init.ArdiumItems;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * @author - Yslohr on 03/03/2019
 */

public class ItemArmorArdium extends ItemArmor {
    public ItemArmorArdium (ArmorMaterial armorMaterial, int armorType) {
        super (armorMaterial, 0, armorType);
    }

    @Override
    public String getArmorTexture (ItemStack stack, Entity entity, int slot, String type) {
        return stack.getItem () == ArdiumItems.ardium_leggings ? Ardium.MOD_ID + ":textures/models/armor/ardium_layer_2.png" : Ardium.MOD_ID + ":textures/models/armor/ardium_layer_1.png";
    }
}