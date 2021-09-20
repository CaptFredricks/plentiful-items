package com.github.captfredricks.plentifulitems.data;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.init.ModBlocks;
import com.github.captfredricks.plentifulitems.init.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

/**
 * This class registers all recipe json files.
 * @since 1.0.1
 */
public final class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void registerRecipes(@Nonnull Consumer<IFinishedRecipe> consumer) {
        // GROUP: BUILDING BLOCKS

        // Steel block
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.STEEL_BLOCK.get())
                .key('#', ModItems.STEEL_INGOT.get())
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
                .build(consumer);

        // GROUP: DECORATION BLOCKS

        // Crate
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CRATE.get())
                .key('P', ItemTags.PLANKS)
                .key('S', ItemTags.WOODEN_SLABS)
                .patternLine("PSP")
                .patternLine("S S")
                .patternLine("PSP")
                .addCriterion("has_planks", hasItem(ItemTags.PLANKS))
                .addCriterion("has_wood_slab", hasItem(ItemTags.WOODEN_SLABS))
                .build(consumer);

        // Reinforced crate
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.REINFORCED_CRATE.get())
                .key('C', ModItems.CRATE.get())
                .key('I', ModItems.STEEL_INGOT.get())
                .key('R', ModItems.STEEL_RIVET.get())
                .patternLine("IRI")
                .patternLine("RCR")
                .patternLine("IRI")
                .addCriterion("has_crate", hasItem(ModItems.CRATE.get()))
                .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
                .addCriterion("has_steel_rivet", hasItem(ModItems.STEEL_RIVET.get()))
                .build(consumer);

        // GROUP: FOODS

        // Butter
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.BUTTER.get(), 3)
                .addIngredient(Items.MILK_BUCKET)
                .addIngredient(ModItems.SALT.get())
                .addCriterion("has_milk", hasItem(Items.MILK_BUCKET))
                .addCriterion("has_salt", hasItem(ModItems.SALT.get()))
                .build(consumer);

        // Cheese
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CHEESE.get(), 2)
                .addIngredient(Items.MILK_BUCKET, 2)
                .addIngredient(ModItems.SALT.get(), 2)
                .addCriterion("has_milk", hasItem(Items.MILK_BUCKET))
                .addCriterion("has_salt", hasItem(ModItems.SALT.get()))
                .build(consumer);

        // Scrambled egg
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.SCRAMBLED_EGG.get())
                .addIngredient(Items.EGG, 2)
                .addIngredient(ModItems.BUTTER.get())
                .addCriterion("has_egg", hasItem(Items.EGG))
                .addCriterion("has_butter", hasItem(ModItems.BUTTER.get()))
                .build(consumer);

        // Coconut cream pie
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.COCONUT_CREAM_PIE.get())
                .addIngredient(ModItems.COCONUT.get())
                .addIngredient(Items.MILK_BUCKET)
                .addIngredient(Items.SUGAR)
                .addCriterion("has_coconut", hasItem(ModItems.COCONUT.get()))
                .build(consumer);

        // Cooked crab (furnace)
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModItems.CRAB.get()), ModItems.COOKED_CRAB.get(), 0.35f, 200)
                .addCriterion("has_crab", hasItem(ModItems.CRAB.get()))
                .build(consumer);

        // Cooked shrimp (furnace)
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModItems.SHRIMP.get()), ModItems.COOKED_SHRIMP.get(), 0.35f, 200)
                .addCriterion("has_shrimp", hasItem(ModItems.SHRIMP.get()))
                .build(consumer);

        // Cooked lobster (furnace)
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModItems.LOBSTER.get()), ModItems.COOKED_LOBSTER.get(), 0.35f, 200)
                .addCriterion("has_lobster", hasItem(ModItems.LOBSTER.get()))
                .build(consumer);

        // Cooking recipes (smoker and campfire)
        cookingRecipes(consumer, "smoking", IRecipeSerializer.SMOKING, 100);
        cookingRecipes(consumer, "campfire_cooking", IRecipeSerializer.CAMPFIRE_COOKING, 600);

        // GROUP: MATERIALS

        // Steel ingot
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.STEEL_INGOT.get(), 9)
                .addIngredient(ModBlocks.STEEL_BLOCK.get())
                .addCriterion("has_steel_block", hasItem(ModBlocks.STEEL_BLOCK.get()))
                .build(consumer, save("steel_ingot_from_steel_block"));

        // Steel ingot (furnace)
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(Items.IRON_INGOT), ModItems.STEEL_INGOT.get(), 0.7f, 200)
                .addCriterion("has_iron_ingot", hasItem(Items.IRON_INGOT))
                .build(consumer);

        // Steel ingot (blast furnace)
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(Items.IRON_INGOT), ModItems.STEEL_INGOT.get(), 0.7f, 100)
                .addCriterion("has_iron_ingot", hasItem(Items.IRON_INGOT))
                .build(consumer, save("steel_ingot_from_blasting"));

        // Steel rivet
        ShapedRecipeBuilder.shapedRecipe(ModItems.STEEL_RIVET.get(), 4)
                .key('#', ModItems.STEEL_INGOT.get())
                .patternLine("##")
                .patternLine("##")
                .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
                .build(consumer);

        // GROUP: TOOLS

        steelSmithingRecipe(consumer, Items.IRON_SHOVEL, ModItems.STEEL_SHOVEL.get());
        steelSmithingRecipe(consumer, Items.IRON_PICKAXE, ModItems.STEEL_PICKAXE.get());
        steelSmithingRecipe(consumer, Items.IRON_AXE, ModItems.STEEL_AXE.get());
        steelSmithingRecipe(consumer, Items.IRON_HOE, ModItems.STEEL_HOE.get());

        // GROUP: COMBAT

        steelSmithingRecipe(consumer, Items.IRON_SWORD, ModItems.STEEL_SWORD.get());
        steelSmithingRecipe(consumer, Items.IRON_HELMET, ModItems.STEEL_HELMET.get());
        steelSmithingRecipe(consumer, Items.IRON_CHESTPLATE, ModItems.STEEL_CHESTPLATE.get());
        steelSmithingRecipe(consumer, Items.IRON_LEGGINGS, ModItems.STEEL_LEGGINGS.get());
        steelSmithingRecipe(consumer, Items.IRON_BOOTS, ModItems.STEEL_BOOTS.get());
    }

    /**
     * Generate all cooking recipes.
     * @since 1.0.1
     * @param consumer the consumer
     * @param consumer_type the consumer's type
     * @param cooking_method the cooking method
     * @param cooking_time the cooking time
     */
    private static void cookingRecipes(final Consumer<IFinishedRecipe> consumer, final String consumer_type, final CookingRecipeSerializer<?> cooking_method, final int cooking_time) {
        // Crab
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModItems.CRAB.get()), ModItems.COOKED_CRAB.get(), 0.35f, cooking_time, cooking_method)
                .addCriterion("has_crab", hasItem(ModItems.CRAB.get()))
                .build(consumer, save("cooked_crab_from_" + consumer_type));

        // Shrimp
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModItems.SHRIMP.get()), ModItems.COOKED_SHRIMP.get(), 0.35f, cooking_time, cooking_method)
                .addCriterion("has_shrimp", hasItem(ModItems.SHRIMP.get()))
                .build(consumer, save("cooked_shrimp_from_" + consumer_type));

        // Lobster
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModItems.LOBSTER.get()), ModItems.COOKED_LOBSTER.get(), 0.35f, cooking_time, cooking_method)
                .addCriterion("has_lobster", hasItem(ModItems.LOBSTER.get()))
                .build(consumer, save("cooked_lobster_from_" + consumer_type));
    }

    /**
     * Generate a smithing recipe for a steel item.
     * @since 1.0.1
     * @param consumer the consumer
     * @param base the base item to upgrade
     * @param output the item to be output
     */
    private static void steelSmithingRecipe(final Consumer<IFinishedRecipe> consumer, final Item base, final Item output) {
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(base), Ingredient.fromItems(ModItems.STEEL_INGOT.get()), output)
                .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
                .build(consumer, save(output.asItem() + "_smithing"));
    }

    /**
     * Set the save location for recipes.
     * @since 1.0.1
     * @param filename the filename
     * @return ResourceLocation
     */
    private static ResourceLocation save(final String filename) {
        return new ResourceLocation(Main.MODID, filename);
    }
}
