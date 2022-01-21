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
    protected void buildShapelessRecipes(@Nonnull Consumer<IFinishedRecipe> consumer) {
        // GROUP: BUILDING BLOCKS

        // Steel block
        ShapedRecipeBuilder.shaped(ModBlocks.STEEL_BLOCK.get())
                .define('#', ModItems.STEEL_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get()))
                .save(consumer);

        // GROUP: DECORATION BLOCKS

        // Crate
        ShapedRecipeBuilder.shaped(ModBlocks.CRATE.get())
                .define('P', ItemTags.PLANKS)
                .define('S', ItemTags.WOODEN_SLABS)
                .pattern("PSP")
                .pattern("S S")
                .pattern("PSP")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .unlockedBy("has_wood_slab", has(ItemTags.WOODEN_SLABS))
                .save(consumer);

        // Reinforced crate
        ShapedRecipeBuilder.shaped(ModBlocks.REINFORCED_CRATE.get())
                .define('C', ModItems.CRATE.get())
                .define('I', ModItems.STEEL_INGOT.get())
                .define('R', ModItems.STEEL_RIVET.get())
                .pattern("IRI")
                .pattern("RCR")
                .pattern("IRI")
                .unlockedBy("has_crate", has(ModItems.CRATE.get()))
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get()))
                .unlockedBy("has_steel_rivet", has(ModItems.STEEL_RIVET.get()))
                .save(consumer);

        // GROUP: FOODS

        // Butter
        ShapelessRecipeBuilder.shapeless(ModItems.BUTTER.get(), 3)
                .requires(Items.MILK_BUCKET)
                .requires(ModItems.SALT.get())
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .unlockedBy("has_salt", has(ModItems.SALT.get()))
                .save(consumer);

        // Cheese
        ShapelessRecipeBuilder.shapeless(ModItems.CHEESE.get(), 2)
                .requires(Items.MILK_BUCKET, 2)
                .requires(ModItems.SALT.get(), 2)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .unlockedBy("has_salt", has(ModItems.SALT.get()))
                .save(consumer);

        // Scrambled egg
        ShapelessRecipeBuilder.shapeless(ModItems.SCRAMBLED_EGG.get())
                .requires(Items.EGG, 2)
                .requires(ModItems.BUTTER.get())
                .unlockedBy("has_egg", has(Items.EGG))
                .unlockedBy("has_butter", has(ModItems.BUTTER.get()))
                .save(consumer);

        // Coconut cream pie
        ShapelessRecipeBuilder.shapeless(ModItems.COCONUT_CREAM_PIE.get())
                .requires(ModItems.COCONUT.get())
                .requires(Items.MILK_BUCKET)
                .requires(Items.SUGAR)
                .unlockedBy("has_coconut", has(ModItems.COCONUT.get()))
                .save(consumer);

        // Cooked crab (furnace)
        CookingRecipeBuilder.smelting(Ingredient.of(ModItems.CRAB.get()), ModItems.COOKED_CRAB.get(), 0.35f, 200)
                .unlockedBy("has_crab", has(ModItems.CRAB.get()))
                .save(consumer);

        // Cooked shrimp (furnace)
        CookingRecipeBuilder.smelting(Ingredient.of(ModItems.SHRIMP.get()), ModItems.COOKED_SHRIMP.get(), 0.35f, 200)
                .unlockedBy("has_shrimp", has(ModItems.SHRIMP.get()))
                .save(consumer);

        // Cooked lobster (furnace)
        CookingRecipeBuilder.smelting(Ingredient.of(ModItems.LOBSTER.get()), ModItems.COOKED_LOBSTER.get(), 0.35f, 200)
                .unlockedBy("has_lobster", has(ModItems.LOBSTER.get()))
                .save(consumer);

        // Cooking recipes (smoker and campfire)
        cookingRecipes(consumer, "smoking", IRecipeSerializer.SMOKING_RECIPE, 100);
        cookingRecipes(consumer, "campfire_cooking", IRecipeSerializer.CAMPFIRE_COOKING_RECIPE, 600);

        // GROUP: MATERIALS

        // Steel ingot
        ShapelessRecipeBuilder.shapeless(ModItems.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK.get())
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK.get()))
                .save(consumer, save("steel_ingot_from_steel_block"));

        // Steel ingot (furnace)
        CookingRecipeBuilder.smelting(Ingredient.of(Items.IRON_INGOT), ModItems.STEEL_INGOT.get(), 0.7f, 200)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(consumer);

        // Steel ingot (blast furnace)
        CookingRecipeBuilder.blasting(Ingredient.of(Items.IRON_INGOT), ModItems.STEEL_INGOT.get(), 0.7f, 100)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(consumer, save("steel_ingot_from_blasting"));

        // Steel rivet
        ShapedRecipeBuilder.shaped(ModItems.STEEL_RIVET.get(), 4)
                .define('#', ModItems.STEEL_INGOT.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get()))
                .save(consumer);

        // GROUP: TOOLS

        steelSmithingRecipe(consumer, Items.IRON_SHOVEL, ModItems.STEEL_SHOVEL.get());
        steelSmithingRecipe(consumer, Items.IRON_PICKAXE, ModItems.STEEL_PICKAXE.get());
        steelSmithingRecipe(consumer, Items.IRON_AXE, ModItems.STEEL_AXE.get());
        steelSmithingRecipe(consumer, Items.IRON_HOE, ModItems.STEEL_HOE.get());

        // GROUP: COMBAT

        // Steel
        steelSmithingRecipe(consumer, Items.IRON_SWORD, ModItems.STEEL_SWORD.get());
        steelSmithingRecipe(consumer, Items.IRON_HELMET, ModItems.STEEL_HELMET.get());
        steelSmithingRecipe(consumer, Items.IRON_CHESTPLATE, ModItems.STEEL_CHESTPLATE.get());
        steelSmithingRecipe(consumer, Items.IRON_LEGGINGS, ModItems.STEEL_LEGGINGS.get());
        steelSmithingRecipe(consumer, Items.IRON_BOOTS, ModItems.STEEL_BOOTS.get());

        // VANILLA ITEMS

        // Bottle o' Enchanting
        ShapelessRecipeBuilder.shapeless(Items.EXPERIENCE_BOTTLE)
                .requires(Items.GHAST_TEAR, 2)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_ghast_tear", has(Items.GHAST_TEAR))
                .save(consumer);

        // Chainmail helmet
        ShapedRecipeBuilder.shaped(Items.CHAINMAIL_HELMET)
                .define('#', Items.IRON_NUGGET)
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
                .save(consumer);

        // Chainmail chestplate
        ShapedRecipeBuilder.shaped(Items.CHAINMAIL_CHESTPLATE)
                .define('#', Items.IRON_NUGGET)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
                .save(consumer);

        // Chainmail leggings
        ShapedRecipeBuilder.shaped(Items.CHAINMAIL_LEGGINGS)
                .define('#', Items.IRON_NUGGET)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
                .save(consumer);

        // Chainmail boots
        ShapedRecipeBuilder.shaped(Items.CHAINMAIL_BOOTS)
                .define('#', Items.IRON_NUGGET)
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
                .save(consumer);

        // Elytra
        ShapedRecipeBuilder.shaped(Items.ELYTRA)
                .define('C', Items.CHORUS_FRUIT)
                .define('M', Items.PHANTOM_MEMBRANE)
                .pattern("MMM")
                .pattern("MCM")
                .pattern("M M")
                .unlockedBy("has_phantom_membrane", has(Items.PHANTOM_MEMBRANE))
                .save(consumer);

        // Enchanted golden apple
        ShapelessRecipeBuilder.shapeless(Items.ENCHANTED_GOLDEN_APPLE)
                .requires(Items.GOLDEN_APPLE)
                .requires(Items.EXPERIENCE_BOTTLE, 2)
                .requires(Items.NETHER_STAR)
                .unlockedBy("has_nether_star", has(Items.NETHER_STAR))
                .save(consumer);

        // Diamond horse armor
        ShapedRecipeBuilder.shaped(Items.DIAMOND_HORSE_ARMOR)
                .define('D', Items.DIAMOND)
                .define('L', Items.LEATHER)
                .pattern("D D")
                .pattern("DLD")
                .pattern("D D")
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(consumer);

        // Golden horse armor
        ShapedRecipeBuilder.shaped(Items.GOLDEN_HORSE_ARMOR)
                .define('G', Items.GOLD_INGOT)
                .define('L', Items.LEATHER)
                .pattern("G G")
                .pattern("GLG")
                .pattern("G G")
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(consumer);

        // Iron horse armor
        ShapedRecipeBuilder.shaped(Items.IRON_HORSE_ARMOR)
                .define('I', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .pattern("I I")
                .pattern("ILI")
                .pattern("I I")
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(consumer);

        // Saddle
        ShapedRecipeBuilder.shaped(Items.SADDLE)
                .define('I', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .pattern("LLL")
                .pattern("L L")
                .pattern("I I")
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(consumer);

        // Totem of Undying
        ShapedRecipeBuilder.shaped(Items.TOTEM_OF_UNDYING)
                .define('D', Items.DRAGON_BREATH)
                .define('E', Items.ENDER_EYE)
                .define('F', Items.RABBIT_FOOT)
                .define('G', Items.GOLD_INGOT)
                .define('S', Items.NETHER_STAR)
                .define('T', Items.GHAST_TEAR)
                .pattern("GEG")
                .pattern("DST")
                .pattern("GFG")
                .unlockedBy("has_dragon_breath", has(Items.DRAGON_BREATH))
                .unlockedBy("has_nether_star", has(Items.NETHER_STAR))
                .save(consumer);
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
        CookingRecipeBuilder.cooking(Ingredient.of(ModItems.CRAB.get()), ModItems.COOKED_CRAB.get(), 0.35f, cooking_time, cooking_method)
                .unlockedBy("has_crab", has(ModItems.CRAB.get()))
                .save(consumer, save("cooked_crab_from_" + consumer_type));

        // Shrimp
        CookingRecipeBuilder.cooking(Ingredient.of(ModItems.SHRIMP.get()), ModItems.COOKED_SHRIMP.get(), 0.35f, cooking_time, cooking_method)
                .unlockedBy("has_shrimp", has(ModItems.SHRIMP.get()))
                .save(consumer, save("cooked_shrimp_from_" + consumer_type));

        // Lobster
        CookingRecipeBuilder.cooking(Ingredient.of(ModItems.LOBSTER.get()), ModItems.COOKED_LOBSTER.get(), 0.35f, cooking_time, cooking_method)
                .unlockedBy("has_lobster", has(ModItems.LOBSTER.get()))
                .save(consumer, save("cooked_lobster_from_" + consumer_type));
    }

    /**
     * Generate a smithing recipe for a steel item.
     * @since 1.0.1
     * @param consumer the consumer
     * @param base the base item to upgrade
     * @param output the item to be output
     */
    private static void steelSmithingRecipe(final Consumer<IFinishedRecipe> consumer, final Item base, final Item output) {
        SmithingRecipeBuilder.smithing(Ingredient.of(base), Ingredient.of(ModItems.STEEL_INGOT.get()), output)
                .unlocks("has_steel_ingot", has(ModItems.STEEL_INGOT.get()))
                .save(consumer, save(output.asItem() + "_smithing"));
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
