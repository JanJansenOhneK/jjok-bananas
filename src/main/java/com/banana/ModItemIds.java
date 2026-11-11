package com.banana;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {

    public static final ResourceKey<Item> BANANA = create("banana");
    public static final ResourceKey<Item> PEELED_BANANA = create("peeled_banana");
    public static final ResourceKey<Item> BANANA_PEEL = create("banana_peel");

    public static ResourceKey<Item> create(String name) {
        // Create the item key.
        return ResourceKey.create(Registries.ITEM, JanJansensBananaMod.id(name));
    }
}