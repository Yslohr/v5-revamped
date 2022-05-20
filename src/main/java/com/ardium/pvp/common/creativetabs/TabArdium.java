package com.ardium.pvp.common.creativetabs;

import com.ardium.pvp.common.init.ArdiumItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author - Yslohr on 03/03/2019
 */

public class TabArdium extends CreativeTabs {
    public TabArdium (String tabArdium) {
        super (CreativeTabs.getNextID (), tabArdium);
        //this.setBackgroundImageName ("item_search.png");
    }

    public Item getTabIconItem () {
        return ArdiumItems.ardium_ingot;
    }

    /*
    public boolean hasSearchBar () {
        return true;
    }
    */
}
