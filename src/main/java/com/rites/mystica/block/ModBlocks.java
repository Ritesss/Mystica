package com.rites.mystica.block;

import com.rites.mystica.Mystica;
import com.rites.mystica.block.custom.ModFlammableRotatedPillarBlock;
import com.rites.mystica.item.ModItems;
import com.rites.mystica.util.MysticaTab;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mystica.MOD_ID);

    public static final RegistryObject<Block> STARLIGHT_ROSE = registerBlock("starlight_rose", () -> new FlowerBlock(
            MobEffects.GLOWING, 8,
            BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion().dynamicShape()), MysticaTab.MTAB);

    public static final RegistryObject<Block> PRISMATIC_ORE = registerBlock("prismatic_ore", () -> new Block(
            BlockBehaviour.Properties.of(Material.STONE).strength(0.3f).requiresCorrectToolForDrops()), MysticaTab.MTAB);

    public static final RegistryObject<Block> PRISMATIC_BOTTLE = registerBlock("prismatic_bottle", () -> new Block(
            BlockBehaviour.Properties.of(Material.GLASS).strength(0.3f).requiresCorrectToolForDrops()), MysticaTab.MTAB);

    public static final RegistryObject<Block> POTTED_STARLIGHT_ROSE = registerBlockWithoutBlockItem("potted_starlight_rose", () -> new FlowerPotBlock(
            null, ModBlocks.STARLIGHT_ROSE,
            BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    public static final RegistryObject<Block> AETHRIL = registerBlock("aethril", () -> new FlowerBlock(
            MobEffects.REGENERATION, 8,
            BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion().dynamicShape()), MysticaTab.MTAB);

    public static final RegistryObject<Block> POTTED_ATHERIL = registerBlockWithoutBlockItem("potted_aethril", () -> new FlowerPotBlock(
            null, ModBlocks.AETHRIL,
            BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    public static final RegistryObject<Block> WITCHWOOD_LOG = registerBlock("witchwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            MysticaTab.MTAB);
    public static final RegistryObject<Block> STRIPPED_WITCHWOOD_LOG = registerBlock("stripped_witchwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            MysticaTab.MTAB);

    public static final RegistryObject<Block> WITCHWOOD_PLANKS = registerBlock("witchwood_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, MysticaTab.MTAB);


    //REGISTER
    private static <T extends  Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }


    private static <T extends  Block>RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
