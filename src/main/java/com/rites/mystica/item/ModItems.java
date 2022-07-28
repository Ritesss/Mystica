package com.rites.mystica.item;
import com.rites.mystica.Mystica;
import com.rites.mystica.util.MysticaTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mystica.MOD_ID);

    public static final RegistryObject<Item> SALIS_MIRUM = ITEMS.register
            ("salis_mirum", () -> new Item(new Item.Properties().tab(MysticaTab.MTAB)));

    public static final RegistryObject<Item> PRISMATIC_CRYSTALS = ITEMS.register
            ("prismatic_crystal", () -> new Item(new Item.Properties().tab(MysticaTab.MTAB)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
