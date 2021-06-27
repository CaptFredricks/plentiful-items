package com.github.captfredricks.plentifulitems.init;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import java.lang.reflect.Field;
import java.util.*;
import javax.annotation.Nonnull;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

/**
 * This class generates a custom loot table for fishing.
 * @since 0.3.0
 */
public final class ModFishingLoot extends LootModifier {
    private final TableLootEntry table;
    private final float weight;
    private static final Field LOOT_FIELD = ObfuscationReflectionHelper.findField(LootContext.class, "field_186504_g");

    public ModFishingLoot(final ILootCondition[] conditionsIn, final TableLootEntry table, final float weight) {
        super(conditionsIn);

        this.table = table;
        this.weight = weight;
    }

    @Nonnull
    @Override
    public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        try {
            Set<LootTable> set = (Set<LootTable>) LOOT_FIELD.get(context);

            if(set.isEmpty() && context.getRandom().nextFloat() <= weight) {
                List<ItemStack> loot = Lists.newArrayList();

                table.func_216154_a(loot::add, context);

                // Return the custom loot
                return loot;
            } else {
                // Return the generated loot
                return generatedLoot;
            }
        } catch(IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException("Could not access lootTables", e);
        }
    }

    public static class Serializer extends GlobalLootModifierSerializer<ModFishingLoot> {
        @Override
        public ModFishingLoot read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
            String loot_table = JSONUtils.getString(object, "table");
            TableLootEntry table = (TableLootEntry)TableLootEntry.builder(new ResourceLocation(loot_table)).build();
            float weight = JSONUtils.getFloat(object,"weight");

            return new ModFishingLoot(conditionsIn, table, weight);
        }

        @Override
        public JsonObject write(ModFishingLoot instance) {
            JsonObject object = makeConditions(instance.conditions);

            object.addProperty("table", instance.table.toString());
            object.addProperty("weight", instance.weight);

            return object;
        }
    }
}
