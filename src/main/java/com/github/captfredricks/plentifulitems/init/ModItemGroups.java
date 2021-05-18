package com.github.captfredricks.plentifulitems.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public final class ModItemGroups {
    public static final ItemGroup PI_BLOCKS = new ModItemGroup("pi_blocks", () -> new ItemStack(ModBlocks.GROUP_ICON.get()));
    public static final ItemGroup PI_ITEMS = new ModItemGroup("pi_items", () -> new ItemStack(ModItems.GROUP_ICON.get()));

    public static final class ModItemGroup extends ItemGroup {
        @Nonnull
        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        @Nonnull
        public ItemStack createIcon() {
            return iconSupplier.get();
        }
    }
}
