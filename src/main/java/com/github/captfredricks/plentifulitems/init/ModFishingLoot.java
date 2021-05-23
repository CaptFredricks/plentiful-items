package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import java.util.List;
import javax.annotation.Nonnull;
import com.google.gson.JsonObject;

public final class ModFishingLoot extends LootModifier {
    public ModFishingLoot(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        LootContext.Builder builder = new LootContext.Builder(context);
        LootContext ctx = builder.build(LootParameterSets.FISHING);
        LootTable table = context.getWorld().getServer().getLootTableManager().getLootTableFromLocation(new ResourceLocation(Main.MODID, "gameplay/fishing/crustaceans"));
        return table.generate(ctx);
    }

    public static class Serializer extends GlobalLootModifierSerializer<ModFishingLoot> {
        @Override
        public ModFishingLoot read(ResourceLocation name, JsonObject json, ILootCondition[] conditionsIn) {
            return new ModFishingLoot(conditionsIn);
        }

        @Override
        public JsonObject write(ModFishingLoot instance) {
            return null;
        }
    }
}
