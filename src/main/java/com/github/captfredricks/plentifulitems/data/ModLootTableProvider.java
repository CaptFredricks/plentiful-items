package com.github.captfredricks.plentifulitems.data;

import com.github.captfredricks.plentifulitems.init.ModBlocks;
import com.github.captfredricks.plentifulitems.init.ModItems;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.*;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * This class generates all loot table json files.
 * @since 1.0.1
 */
public final class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator gen) {
        super(gen);
    }

    @Nonnull
    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationTracker validationtracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> LootTableManager.validate(validationtracker, p_218436_2_, p_218436_3_));
    }

    public static class ModBlockLootTables extends BlockLootTables {
        @Override
        protected void addTables() {
            // Building blocks
            add(ModBlocks.HALITE.get(), (halite) ->
                    createSilkTouchDispatchTable(halite, applyExplosionDecay(halite, ItemLootEntry.lootTableItem(ModItems.SALT.get())
                            .apply(SetCount.setCount(RandomValueRange.between(3.0f, 5.0f)))
                            .apply(ApplyBonus.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))
            );
            /*registerLootTable(ModBlocks.HALITE.get(), (halite) ->
                    droppingWithSilkTouch(halite, withExplosionDecay(halite, ItemLootEntry.builder(ModItems.SALT.get())
                        .acceptFunction(SetCount.builder(RandomValueRange.of(3.0f, 5.0f)))
                        .acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))))
            );*/
            dropSelf(ModBlocks.STEEL_BLOCK.get());
            //registerDropSelfLootTable(ModBlocks.STEEL_BLOCK.get());

            // Decoration blocks
            add(ModBlocks.CRATE.get(), createNameableBlockEntityTable(ModBlocks.CRATE.get()));
            //registerLootTable(ModBlocks.CRATE.get(), droppingWithName(ModBlocks.CRATE.get()));
            add(ModBlocks.REINFORCED_CRATE.get(), createShulkerBoxDrop(ModBlocks.REINFORCED_CRATE.get()));
            //registerLootTable(ModBlocks.REINFORCED_CRATE.get(), droppingWithContents(ModBlocks.REINFORCED_CRATE.get()));
        }

        @Nonnull
        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
        }
    }
}
