package com.github.captfredricks.plentifulitems.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import javax.annotation.Nonnull;
import java.util.function.Supplier;

/**
 * This class defines the custom item groups for the mod.
 * @since 0.1.0
 */
public final class ModItemGroups {
    public static final ItemGroup PI_BLOCKS = new ModItemGroup("pi_blocks", () -> new ItemStack(ModBlocks.BLOCKS_ICON.get()));
    public static final ItemGroup PI_FOODS = new ModItemGroup("pi_foods", () -> new ItemStack(ModItems.FOODS_ICON.get()));
    public static final ItemGroup PI_MATERIALS = new ModItemGroup("pi_materials", () -> new ItemStack(ModItems.MATS_ICON.get()));
    public static final ItemGroup PI_TOOLS = new ModItemGroup("pi_tools", () -> new ItemStack(ModItems.TOOLS_ICON.get()));
    public static final ItemGroup PI_COMBAT = new ModItemGroup("pi_combat", () -> new ItemStack(ModItems.COMBAT_ICON.get()));

    public static final class ModItemGroup extends ItemGroup {
        @Nonnull
        private final Supplier<ItemStack> iconSupplier;

        /**
         * The class constructor.
         * @param name the item group's name
         * @param iconSupplier the icon supplier
         */
        public ModItemGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        /**
         * Create an icon for the item group.
         * @return ItemStack
         */
        @Nonnull
        @Override
        public ItemStack makeIcon() { return iconSupplier.get(); }
    }
}
