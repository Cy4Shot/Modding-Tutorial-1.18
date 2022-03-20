package com.cy4.tutorialmod.datagen.server;

import com.cy4.tutorialmod.TutorialMod;
import com.cy4.tutorialmod.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blocks, ExistingFileHelper helper) {
		super(generator, blocks, TutorialMod.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(Tags.Items.BARRELS).add(BlockInit.ROTATABLE_BLOCK.get().asItem());
	}

}
