package com.banana;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Banana extends Item {
    public Banana(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResult use(Level level, Player user, InteractionHand hand) {

        // Ensure we don't spawn the lightning only on the client.
        // This is to prevent desync.

        Inventory inventory = user.getInventory();

        inventory.add(new ItemStack(ModItems.PEELED_BANANA));
        inventory.add(new ItemStack(ModItems.BANANA_PEEL));
        inventory.removeItem(inventory.getSelectedSlot(),1);

        return InteractionResult.SUCCESS;
    }

}
