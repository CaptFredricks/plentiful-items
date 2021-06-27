package com.github.captfredricks.plentifulitems.init;

/**
 * This class generates a custom loot table for jungle leaves.
 * @since 0.5.0
 */

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;
import javax.annotation.Nonnull;
import com.google.gson.JsonObject;

public final class ModJungleLeavesLoot extends LootModifier {
    private final List<Item> items = new ArrayList<>();
    private final List<Item> food_items = new ArrayList<>();

    public ModJungleLeavesLoot(final ILootCondition[] conditionsIn, final Map<String, Item> items) {
        super(conditionsIn);

        this.items.add(items.get("sapling"));
        this.items.add(items.get("stick"));

        this.food_items.add(items.get("banana"));
        this.food_items.add(items.get("mango"));
        this.food_items.add(items.get("coconut"));
    }

    @Nonnull
    @Override
    public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        // Clear all generated loot
        generatedLoot.clear();

        // Seed a random number generator
        Random rand = new Random();

        // Create two random numbers
        double rand_1 = rand.nextDouble();
        double rand_2 = rand.nextDouble();

        // Create arrays to hold the probabilities
        // 0: food, 1: stick, 2: sapling
        double[][] probabilities = new double[][]{
                {0.005, 0.02, 0.025}, // Unenchanted
                {0.0055555557, 0.022222223, 0.027777778}, // Fortune I
                {0.00625, 0.025, 0.03125}, // Fortune II
                {0.008333334, 0.033333335, 0.041666668}, // Fortune III
                {0.025, 0.1, 0.1} // Fortune IV+
        };
        double[] probs = new double[]{0.005, 0.02, 0.025}; // No tool

        // Get the current tool
        ItemStack ctx_tool = context.get(LootParameters.TOOL);

        int ctx_enchant_lvl; // Current enchantment level

        if(ctx_tool != null) {
            // Get the current enchantment level
            ctx_enchant_lvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, ctx_tool);

            // Loop through the probabilities
            for(int i = 0; i < probabilities.length; i++) {
                if(i == ctx_enchant_lvl || ctx_enchant_lvl > 4) {
                    for(int j = 0; j < probabilities[i].length; j++) {
                        if(ctx_enchant_lvl > 4) {
                            probs[j] = probabilities[4][j];
                        } else {
                            probs[j] = probabilities[i][j];
                        }
                    }
                    break;
                }
            }
        }

        Item loot_item = null; // The item to add to the generated loot
        int count = 1; // How many items to drop
        double p_total = 0.0, p_tot = 0.0; // The probability totals

        // Loop through the probabilities
        for(int i = 0; i < probs.length; i++) {
            if(rand_1 <= probs[i] + p_total) {
                if(i == 0) {
                    for(Item food_item : food_items) {
                        if(rand_2 <= 0.033333333 + p_tot) {
                            // Give a 20% chance of dropping 2 food items
                            if(rand.nextDouble() <= 0.2) count = 2;

                            // Drop a food item
                            loot_item = food_item;
                            break;
                        }

                        // Add the current probability to the probability total
                        p_tot += 0.033333335;
                    }
                } else if(i == probs.length - 1) {
                    // Give a 40% chance of dropping 2 sticks
                    if(rand_2 <= 0.4) count = 2;

                    // Drop a stick
                    loot_item = items.get(1);
                } else {
                    // Drop a sapling
                    loot_item = items.get(0);
                }

                // Add the item(s) to the generated loot
                generatedLoot.add(new ItemStack(loot_item, count));
                break;
            }

            // Add the current probability to the probability total
            p_total += probs[i];
        }

        // Return the generated loot
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<ModJungleLeavesLoot> {
        @Override
        public ModJungleLeavesLoot read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
            // Create a hashmap to hold the items
            Map<String, Item> items = new HashMap<>();

            // Add all of the items to the list
            items.put("sapling", ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "sapling"))));
            items.put("stick", ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "stick"))));
            items.put("banana", ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "banana"))));
            items.put("mango", ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "mango"))));
            items.put("coconut", ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "coconut"))));

            return new ModJungleLeavesLoot(conditionsIn, items);
        }

        @Override
        public JsonObject write(ModJungleLeavesLoot instance) {
            return null;
        }
    }
}
