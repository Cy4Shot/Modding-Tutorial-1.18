package com.cy4.tutorialmod.datagen.server;

import com.cy4.tutorialmod.datagen.BaseLootTableProvider;
import com.cy4.tutorialmod.init.BlockInit;
import com.cy4.tutorialmod.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModLootTableProvider extends BaseLootTableProvider {

	public ModLootTableProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void addTables() {
		dropSelf(BlockInit.EXAMPLE_BLOCK.get());
		silkTouch(BlockInit.ROTATABLE_BLOCK.get(), ItemInit.EXAMPLE_ITEM.get(), 1, 4);
	}

	protected void silkTouch(Block block, Item silk, int min, int max) {
		add(block, createSilkTouchTable(block.getRegistryName().getPath(), block, silk, min, max));
	}

	protected void dropSelf(Block block) {
		add(block, createSimpleTable(block.getRegistryName().getPath(), block));
	}
}
