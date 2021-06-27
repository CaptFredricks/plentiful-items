package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.init.ModItems;
import java.util.function.Supplier;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * This enum registers custom armor materials.
 * @since 0.4.0
 */
@MethodsReturnNonnullByDefault
public enum ModArmorMaterial implements IArmorMaterial {
    STEEL("steel", 504, new int[]{2, 5, 6, 2}, 14, "item.armor.equip_iron", () -> Ingredient.fromItems(ModItems.STEEL.get()), 1.0f, 0.0f);

    private static final int[] maxDamageArray = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durability;
    private final int[] damageReductionAmount;
    private final int enchantability;
    private final String soundEvent;
    private final Supplier<Ingredient> repairMaterial;
    private final float toughness;
    private final float knockbackResistance;

    ModArmorMaterial(final String name, final int durability, final int[] damageReductionAmount, final int enchantability, final String soundEvent, final Supplier<Ingredient> repairMaterial, final float toughness, final float knockbackResistance) {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmount = damageReductionAmount;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.repairMaterial = repairMaterial;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurability(EquipmentSlotType slot) {
        return maxDamageArray[slot.getIndex()] * this.durability;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slot) {
        return this.damageReductionAmount[slot.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return new SoundEvent(new ResourceLocation(soundEvent));
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return Main.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
