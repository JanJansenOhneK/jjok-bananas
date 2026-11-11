package com.banana;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.function.Function;

public class ModItems {

    public static final Item BANANA = register(ModItemIds.BANANA, Banana::new, new Item.Properties());
    public static final Item PEELED_BANANA = register(
        ModItemIds.PEELED_BANANA,
        Item::new,
        new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(10)
            .alwaysEdible()
            .build()
        ,Consumables.defaultFood()
            // The duration is in ticks, 20 ticks = 1 second
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.ABSORPTION, 120 * 20, 5), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 120 * 20, 5), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 120 * 20, 5), 1.0f))
            .build()
        )
    );
    public static final Item BANANA_PEEL = register(ModItemIds.BANANA_PEEL, Item::new, new Item.Properties());
    public static final Item BANANA_HAND = ModBlocks.BANANA_HAND.asItem();
    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
    }

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
        BuiltInRegistries.CREATIVE_MODE_TAB.key(), JanJansensBananaMod.id("creative_tab")
    );
    public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
        .icon(() -> new ItemStack(ModItems.BANANA))
        .title(Component.translatable("creativeTab.banana-stuff"))
        .displayItems((params, output) -> {
            output.accept(ModItems.BANANA);
            output.accept(ModItems.PEELED_BANANA);
            output.accept(ModItems.BANANA_PEEL);
            output.accept(ModItems.BANANA_HAND);
        })
        .build();
    // Register the group.
}
