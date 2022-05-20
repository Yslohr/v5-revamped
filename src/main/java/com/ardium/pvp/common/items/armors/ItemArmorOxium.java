package com.ardium.pvp.common.items.armors;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.common.init.ArdiumItems;
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

public class ItemArmorOxium extends ItemArmor {
    public ItemArmorOxium (final ArmorMaterial armorMaterial, final int armorType) {
        super (armorMaterial, 0, armorType);
    }

    @Override
    public void onArmorTick (final World world, final EntityPlayer player, final ItemStack itemStack) {
        if ( player.getCurrentArmor (3) != null
                && player.getCurrentArmor (3).getItem () != null
                && player.getCurrentArmor (3).getItem () == ArdiumItems.oxium_helmet ) {
            player.addPotionEffect (new PotionEffect (Potion.nightVision.getId (), 220, 1));
        }

        if ( player.getCurrentArmor (2) != null
                && player.getCurrentArmor (2).getItem () != null
                && player.getCurrentArmor (2).getItem () == ArdiumItems.oxium_chestplate ) {
            player.addPotionEffect (new PotionEffect (Potion.damageBoost.getId (), 220, 1));
        }

        if ( player.getCurrentArmor (1) != null
                && player.getCurrentArmor (1).getItem () != null
                && player.getCurrentArmor (1).getItem () == ArdiumItems.oxium_leggings ) {
            player.addPotionEffect (new PotionEffect (Potion.digSpeed.getId (), 220, 1));
        }

        if ( player.getCurrentArmor (0) != null
                && player.getCurrentArmor (0).getItem () != null
                && player.getCurrentArmor (0).getItem () == ArdiumItems.oxium_boots ) {
            player.addPotionEffect (new PotionEffect (Potion.moveSpeed.getId (), 220, 1));
        }
    }

    @Override
    public String getArmorTexture (final ItemStack stack, final Entity entity, final int slot, final String type) {
        return slot == 2 ? Ardium.MOD_ID + ":textures/models/armor/oxium_layer_2.png" : Ardium.MOD_ID + ":textures/models/armor/oxium_layer_1.png";
    }

}