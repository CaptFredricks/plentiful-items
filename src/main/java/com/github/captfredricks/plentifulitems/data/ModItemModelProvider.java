package com.github.captfredricks.plentifulitems.data;

import com.github.captfredricks.plentifulitems.Main;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * This class generates all block item model and item model json files.
 * @since 1.0.1
 */
public final class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator gen, ExistingFileHelper existing_file_helper) {
        super(gen, Main.MODID, existing_file_helper);
    }

    @Override
    protected void registerModels() {
        // Building blocks
        withExistingParent("halite", modLoc("block/halite"));
        withExistingParent("steel_block", modLoc("block/steel_block"));

        // Decoration blocks
        withExistingParent("crate", modLoc("block/crate"));
        withExistingParent("reinforced_crate", modLoc("block/reinforced_crate"));

        // Parents
        ModelFile item_generated = getExistingFile(mcLoc("item/generated"));
        ModelFile item_handheld = getExistingFile(mcLoc("item/handheld"));

        // Foods
        builder("banana", item_generated);
        builder("mango", item_generated);
        builder("coconut", item_generated);
        builder("butter", item_generated);
        builder("cheese", item_generated);
        builder("scrambled_egg", item_generated);
        builder("coconut_cream_pie", item_generated);
        builder("crab", item_generated);
        builder("cooked_crab", item_generated);
        builder("shrimp", item_generated);
        builder("cooked_shrimp", item_generated);
        builder("lobster", item_generated);
        builder("cooked_lobster", item_generated);

        // Materials
        builder("salt", item_generated);
        builder("steel_ingot", item_generated);
        builder("steel_rivet", item_generated);

        // Tools
        builder("steel_shovel", item_handheld);
        builder("steel_pickaxe", item_handheld);
        builder("steel_axe", item_handheld);
        builder("steel_hoe", item_handheld);

        // Weapons
        builder("steel_sword", item_handheld);

        // Armor
        builder("steel_helmet", item_generated);
        builder("steel_chestplate", item_generated);
        builder("steel_leggings", item_generated);
        builder("steel_boots", item_generated);
    }

    private ItemModelBuilder builder(final String name, final ModelFile parent_model) {
        return getBuilder(name).parent(parent_model).texture("layer0", "item/" + name);
    }
}
