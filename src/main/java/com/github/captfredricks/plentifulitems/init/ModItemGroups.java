package com.github.captfredricks.plentifulitems.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import javax.annotation.Nonnull;
import java.util.function.Supplier;

public final class ModItemGroups {
    public static final ItemGroup PI_BLOCKS = new ModItemGroup("pi_blocks", () -> new ItemStack(ModBlocks.BLOCKS_ICON.get()));
    public static final ItemGroup PI_FOODS = new ModItemGroup("pi_foods", () -> new ItemStack(ModItems.FOODS_ICON.get()));
    public static final ItemGroup PI_MATERIALS = new ModItemGroup("pi_materials", () -> new ItemStack(ModItems.MATS_ICON.get()));
    public static final ItemGroup PI_TOOLS = new ModItemGroup("pi_tools", () -> new ItemStack(ModItems.TOOLS_ICON.get()));
    public static final ItemGroup PI_WEAPONS = new ModItemGroup("pi_weapons", () -> new ItemStack(ModItems.WEAPONS_ICON.get()));

    public static final class ModItemGroup extends ItemGroup {
        @Nonnull
        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        @Nonnull
        public ItemStack createIcon() { return iconSupplier.get(); }
    }
}
