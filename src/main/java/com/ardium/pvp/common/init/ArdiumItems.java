package com.ardium.pvp.common.init;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.common.items.*;
import com.ardium.pvp.common.items.armors.ItemArmorArdium;
import com.ardium.pvp.common.items.armors.ItemArmorDeath;
import com.ardium.pvp.common.items.armors.ItemArmorOxium;
import com.ardium.pvp.common.items.tools.ItemAxeBase;
import com.ardium.pvp.common.items.tools.ItemMultiToolsBase;
import com.ardium.pvp.common.items.tools.ItemPickaxeBase;
import com.ardium.pvp.common.items.tools.ItemSwordBase;
import com.ardium.pvp.common.items.tools.admin.ItemSwordLava;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @author - Yslohr on 03/03/2019
 */

public class ArdiumItems {
    private static final Item.ToolMaterial ARDIUM_TOOLS = EnumHelper.addToolMaterial ("ARDIUM", 3, 2000, 20.0f, 5.0f, 25);
    private static final Item.ToolMaterial OXIUM_TOOLS = EnumHelper.addToolMaterial ("OXIUM", 3, 4000, 30.0f, 8.0f, 25);
    //private static final Item.ToolMaterial ADMIN = EnumHelper.addToolMaterial ("ADMIN", 9999, 99999999, 1.0E8f, 1.0E14f, 99999);
    private static final ItemArmor.ArmorMaterial ARDIUM_ARMOR = EnumHelper.addArmorMaterial ("ARDIUM", 100, new int[] {4, 9, 7, 4}, 20);
    private static final ItemArmor.ArmorMaterial OXIUM_ARMOR = EnumHelper.addArmorMaterial ("OXIUM", 350, new int[] {5, 10, 8, 5}, 30);
    private static final ItemArmor.ArmorMaterial DEATH_ARMOR = EnumHelper.addArmorMaterial ("DEATH", 250, new int[] {50, 50, 50, 50}, 40);
    public static Item ardium_ingot, oxium_ingot, oxium_nugget, oxium_fragment;
    public static Item ardium_helmet, ardium_chestplate, ardium_leggings, ardium_boots;
    public static Item ardium_apple/*,ardium_potion*/;

    public static Item oxium_sword, oxium_shovel, oxium_pickaxe, oxium_axe, oxium_multitools;
    public static Item oxium_helmet, oxium_chestplate, oxium_leggings, oxium_boots;
    public static Item death_helmet, death_chestplate, death_leggings, death_boots;
    private static Item ardium_sword, ardium_shovel, ardium_pickaxe, ardium_axe, ardium_multitools;
    private static Item /*admin_tool,*/ wand_explorer, obsidian_breaker, fire_sword;

    public static void initialization () {

        /*
         * Crafting Materials
         */

        ardium_ingot = new ItemBeaconable ().setUnlocalizedName ("ingotArdium").setTextureName (Ardium.MOD_ID + ":ardium_ingot").setCreativeTab (Ardium.TAB_ARDIUM);
        ARDIUM_TOOLS.setRepairItem (new ItemStack (ardium_ingot));
        ARDIUM_ARMOR.customCraftingMaterial = ardium_ingot;
        oxium_ingot = new ItemBeaconable ().setUnlocalizedName ("ingotOxium").setTextureName (Ardium.MOD_ID + ":oxium_ingot").setCreativeTab (Ardium.TAB_ARDIUM);
        OXIUM_TOOLS.setRepairItem (new ItemStack (oxium_ingot));
        OXIUM_ARMOR.customCraftingMaterial = oxium_ingot;
        oxium_nugget = new Item ().setUnlocalizedName ("oxiumNugget").setCreativeTab (Ardium.TAB_ARDIUM).setTextureName (Ardium.MOD_ID + ":oxium_nugget");
        oxium_fragment = new Item ().setUnlocalizedName ("oxiumFragment").setCreativeTab (Ardium.TAB_ARDIUM).setTextureName (Ardium.MOD_ID + ":oxium_fragment");

        /*
         *  Ardium Tools
         */
        ardium_sword = new ItemSwordBase (ARDIUM_TOOLS).setUnlocalizedName ("swordArdium").setTextureName (Ardium.MOD_ID + ":ardium_sword").setCreativeTab (Ardium.TAB_ARDIUM);
        ardium_shovel = new ItemSpade (ARDIUM_TOOLS).setUnlocalizedName ("shovelArdium").setTextureName (Ardium.MOD_ID + ":ardium_shovel").setCreativeTab (Ardium.TAB_ARDIUM);
        ardium_pickaxe = new ItemPickaxeBase (ARDIUM_TOOLS).setUnlocalizedName ("pickaxeArdium").setTextureName (Ardium.MOD_ID + ":ardium_pickaxe").setCreativeTab (Ardium.TAB_ARDIUM);
        ardium_axe = new ItemAxeBase (ARDIUM_TOOLS).setUnlocalizedName ("hatchetArdium").setTextureName (Ardium.MOD_ID + ":ardium_axe").setCreativeTab (Ardium.TAB_ARDIUM);
        ardium_multitools = new ItemMultiToolsBase (ARDIUM_TOOLS).setUnlocalizedName ("multiToolsArdium").setTextureName (Ardium.MOD_ID + ":ardium_multitools").setCreativeTab (Ardium.TAB_ARDIUM);

        /*
         * Ardium Armor
         */
        ardium_helmet = new ItemArmorArdium (ARDIUM_ARMOR, 0).setUnlocalizedName ("helmetArdium").setTextureName (Ardium.MOD_ID + ":ardium_helmet").setCreativeTab (Ardium.TAB_ARDIUM);
        ardium_chestplate = new ItemArmorArdium (ARDIUM_ARMOR, 1).setUnlocalizedName ("chestplateArdium").setTextureName (Ardium.MOD_ID + ":ardium_chestplate").setCreativeTab (Ardium.TAB_ARDIUM);
        ardium_leggings = new ItemArmorArdium (ARDIUM_ARMOR, 2).setUnlocalizedName ("leggingsArdium").setTextureName (Ardium.MOD_ID + ":ardium_leggings").setCreativeTab (Ardium.TAB_ARDIUM);
        ardium_boots = new ItemArmorArdium (ARDIUM_ARMOR, 3).setUnlocalizedName ("bootsArdium").setTextureName (Ardium.MOD_ID + ":ardium_boots").setCreativeTab (Ardium.TAB_ARDIUM);

        /*
         * Ardium Miscellaneous Items
         */

        ardium_apple = new ItemFoodArdiumApple(10, 10f, false).setAlwaysEdible().setUnlocalizedName("appleArdium").setTextureName(Ardium.MOD_ID + ":apple_ardium").setCreativeTab(Ardium.TAB_ARDIUM);
        //ardium_potion = new ItemArdiumPotion(0, 0f, false).setUnlocalizedName("ardium_potion").setTextureName(Ardium.MOD_ID + ":ardium_potion").setCreativeTab(Ardium.TAB_ARDIUM);


        /*
         *  Oxium Tools
         */
        oxium_sword = new ItemSwordBase (OXIUM_TOOLS).setUnlocalizedName ("swordOxium").setTextureName (Ardium.MOD_ID + ":oxium_sword").setCreativeTab (Ardium.TAB_ARDIUM);
        oxium_shovel = new ItemSpade (OXIUM_TOOLS).setUnlocalizedName ("shovelOxium").setTextureName (Ardium.MOD_ID + ":oxium_shovel").setCreativeTab (Ardium.TAB_ARDIUM);
        oxium_pickaxe = new ItemPickaxeBase (OXIUM_TOOLS).setUnlocalizedName ("pickaxeOxium").setTextureName (Ardium.MOD_ID + ":oxium_pickaxe").setCreativeTab (Ardium.TAB_ARDIUM);
        oxium_axe = new ItemAxeBase (OXIUM_TOOLS).setUnlocalizedName ("hatchetOxium").setTextureName (Ardium.MOD_ID + ":oxium_axe").setCreativeTab (Ardium.TAB_ARDIUM);
        oxium_multitools = new ItemMultiToolsBase (OXIUM_TOOLS).setUnlocalizedName ("multiToolsOxium").setTextureName (Ardium.MOD_ID + ":oxium_multitools").setCreativeTab (Ardium.TAB_ARDIUM);

        /*
         * Oxium Armor
         */

        oxium_helmet = new ItemArmorOxium (OXIUM_ARMOR, 0).setUnlocalizedName ("helmetOxium").setTextureName (Ardium.MOD_ID + ":oxium_helmet").setCreativeTab (Ardium.TAB_ARDIUM);
        oxium_chestplate = new ItemArmorOxium (OXIUM_ARMOR, 1).setUnlocalizedName ("chestplateOxium").setTextureName (Ardium.MOD_ID + ":oxium_chestplate").setCreativeTab (Ardium.TAB_ARDIUM);
        oxium_leggings = new ItemArmorOxium (OXIUM_ARMOR, 2).setUnlocalizedName ("leggingsOxium").setTextureName (Ardium.MOD_ID + ":oxium_leggings").setCreativeTab (Ardium.TAB_ARDIUM);
        oxium_boots = new ItemArmorOxium (OXIUM_ARMOR, 3).setUnlocalizedName ("bootsOxium").setTextureName (Ardium.MOD_ID + ":oxium_boots").setCreativeTab (Ardium.TAB_ARDIUM);

        /*
         * Special Items
         */
        fire_sword = new ItemSwordLava (OXIUM_TOOLS).setUnlocalizedName ("swordFire").setTextureName (Ardium.MOD_ID + ":fire_sword").setCreativeTab (Ardium.TAB_ARDIUM);
        death_helmet = new ItemArmorDeath (DEATH_ARMOR, 0).setUnlocalizedName ("helmetDeath").setTextureName (Ardium.MOD_ID + ":death_helmet").setCreativeTab (Ardium.TAB_ARDIUM);
        death_chestplate = new ItemArmorDeath (DEATH_ARMOR, 1).setUnlocalizedName ("chestplateDeath").setTextureName (Ardium.MOD_ID + ":death_chestplate").setCreativeTab (Ardium.TAB_ARDIUM);
        death_leggings = new ItemArmorDeath (DEATH_ARMOR, 2).setUnlocalizedName ("leggingsDeath").setTextureName (Ardium.MOD_ID + ":death_leggings").setCreativeTab (Ardium.TAB_ARDIUM);
        death_boots = new ItemArmorDeath (DEATH_ARMOR, 3).setUnlocalizedName ("bootsDeath").setTextureName (Ardium.MOD_ID + ":death_boots").setCreativeTab (Ardium.TAB_ARDIUM);

        wand_explorer = new ItemWandExplorer().setUnlocalizedName ("wandExplorer").setTextureName (Ardium.MOD_ID + ":wand_explorer").setCreativeTab (Ardium.TAB_ARDIUM);
        obsidian_breaker = new ItemObsidianBreaker().setUnlocalizedName ("obsidianBreaker").setTextureName (Ardium.MOD_ID + ":obsidian_breaker").setCreativeTab (Ardium.TAB_ARDIUM);

        registerItems ();
    }

    private static void registerItems () {
        //Crafting Materials
        GameRegistry.registerItem (ardium_ingot, "ardium_ingot");
        GameRegistry.registerItem (oxium_ingot, "oxium_ingot");
        GameRegistry.registerItem (oxium_nugget, "oxium_nugget");
        GameRegistry.registerItem (oxium_fragment, "oxium_fragment");
        //Ardium Tools
        GameRegistry.registerItem (ardium_sword, "ardium_sword");
        GameRegistry.registerItem (ardium_shovel, "ardium_shovel");
        GameRegistry.registerItem (ardium_pickaxe, "ardium_pickaxe");
        GameRegistry.registerItem (ardium_axe, "ardium_axe");
        GameRegistry.registerItem (ardium_multitools, "ardium_multitools");
        //Ardium Armor
        GameRegistry.registerItem (ardium_helmet, "ardium_helmet");
        GameRegistry.registerItem (ardium_chestplate, "ardium_chestplate");
        GameRegistry.registerItem (ardium_leggings, "ardium_leggings");
        GameRegistry.registerItem (ardium_boots, "ardium_boots");

        //Ardium Miscellaneous Items
        GameRegistry.registerItem(ardium_apple, "ardium_apple");
        //GameRegistry.registerItem(ardium_potion, "ardium_potion");

        //Oxium Tools
        GameRegistry.registerItem (oxium_sword, "oxium_sword");
        GameRegistry.registerItem (oxium_shovel, "oxium_shovel");
        GameRegistry.registerItem (oxium_pickaxe, "oxium_pickaxe");
        GameRegistry.registerItem (oxium_axe, "oxium_axe");
        GameRegistry.registerItem (oxium_multitools, "oxium_multitools");
        //Oxium Armor
        GameRegistry.registerItem (oxium_helmet, "oxium_helmet");
        GameRegistry.registerItem (oxium_chestplate, "oxium_chestplate");
        GameRegistry.registerItem (oxium_leggings, "oxium_leggings");
        GameRegistry.registerItem (oxium_boots, "oxium_boots");
        //Special Items
        GameRegistry.registerItem (fire_sword, "fire_sword");
        GameRegistry.registerItem (death_helmet, "death_helmet");
        GameRegistry.registerItem (death_chestplate, "death_chestplate");
        GameRegistry.registerItem (death_leggings, "death_leggings");
        GameRegistry.registerItem (death_boots, "death_boots");

        GameRegistry.registerItem (wand_explorer, "wand_explorer");
        GameRegistry.registerItem (obsidian_breaker, "obsidian_breaker");
    }
}