package com.cy4.tutorialmod.datagen.client.lang;

import com.cy4.tutorialmod.TutorialMod;
import com.cy4.tutorialmod.init.BlockInit;
import com.cy4.tutorialmod.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider {

	public ModEnUsProvider(DataGenerator gen) {
		super(gen, TutorialMod.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		
		// Item Groups
		add("itemGroup.tutorialmod", "Tutorial Mod Tab");
		
		// Items
		add(ItemInit.EXAMPLE_ITEM.get(), "Example Item");
		
		// Blocks
		add(BlockInit.EXAMPLE_BLOCK.get(), "Example Block");
		add(BlockInit.ROTATABLE_BLOCK.get(), "Rotatable Block");
	}

}
