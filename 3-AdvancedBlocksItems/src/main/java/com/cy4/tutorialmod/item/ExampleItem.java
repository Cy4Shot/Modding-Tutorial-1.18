package com.cy4.tutorialmod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class ExampleItem extends Item {

	public ExampleItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		
		if (!world.isClientSide()) {
			System.out.println(player.getName().getString() + " has used item with hand " + hand.name());
		}
		
		return super.use(world, player, hand);
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
		return 1000; // 1000 ticks = 1000 / 20 seconds (50s)
	}

}
