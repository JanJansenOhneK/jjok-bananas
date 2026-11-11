package com.banana;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class ModBlockItemIds {

    public static final BlockItemId BANANA_HAND = create("banana_hand");

    private static BlockItemId create(String name) {
        Identifier id = JanJansensBananaMod.id(name);
        return BlockItemId.create(id, id);
    }
}