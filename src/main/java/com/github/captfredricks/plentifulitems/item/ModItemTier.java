package com.github.captfredricks.plentifulitems.item;

/**
 * This enum registers custom item tiers.
 * @since 0.4.0
 */

import com.github.captfredricks.plentifulitems.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import mcp.MethodsReturnNonnullByDefault;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
public enum ModItemTier implements IItemTier {
    STEEL(504, 7.0f, 2.0f, 2, 14, () -> Ingredient.fromItems(ModItems.STEEL.get()));

    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final int harvestLevel;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(final int durability, final float efficiency, final float attackDamage, final int harvestLevel, final int enchantability, final Supplier<Ingredient> repairMaterial) {
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return this.durability;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }
}
