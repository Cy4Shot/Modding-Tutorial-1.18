package com.cy4.tutorialmod.datagen;

import com.cy4.tutorialmod.TutorialMod;
import com.cy4.tutorialmod.datagen.client.ModBlockStateProvider;
import com.cy4.tutorialmod.datagen.client.ModItemModelProvider;
import com.cy4.tutorialmod.datagen.client.lang.ModEnUsProvider;
import com.cy4.tutorialmod.datagen.server.ModBlockTagsProvider;
import com.cy4.tutorialmod.datagen.server.ModItemTagsProvider;
import com.cy4.tutorialmod.datagen.server.ModLootTableProvider;
import com.cy4.tutorialmod.datagen.server.ModRecipeProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.MOD)
public class TutorialDataGeneration {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		
		if (event.includeClient()) {
			
			// Client Data Generation
			generator.addProvider(new ModBlockStateProvider(generator, helper));
			generator.addProvider(new ModItemModelProvider(generator, helper));
			generator.addProvider(new ModEnUsProvider(generator));
		}
		
		if (event.includeServer()) {
			
			ModBlockTagsProvider blockTags = new ModBlockTagsProvider(generator, helper);
			
			// Server Data Generation
			generator.addProvider(new ModRecipeProvider(generator));
			generator.addProvider(blockTags);
			generator.addProvider(new ModItemTagsProvider(generator, blockTags, helper));
			generator.addProvider(new ModLootTableProvider(generator));
			
		}
	}
}
