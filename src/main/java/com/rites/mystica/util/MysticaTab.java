package com.rites.mystica.util;

import com.rites.mystica.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MysticaTab {
    public static final CreativeModeTab MTAB = new CreativeModeTab("mysticatab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SALIS_MIRUM.get());
        }
    };
}