package com.cy4.tutorialmod.datagen.client;

import com.cy4.tutorialmod.TutorialMod;
import com.cy4.tutorialmod.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

	public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, TutorialMod.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(BlockInit.EXAMPLE_BLOCK.get());
	}
}
