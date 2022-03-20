package com.cy4.tutorialmod.datagen.server;

import com.cy4.tutorialmod.TutorialMod;
import com.cy4.tutorialmod.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, TutorialMod.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(Tags.Blocks.DIRT).add(BlockInit.ROTATABLE_BLOCK.get());
	}

}
