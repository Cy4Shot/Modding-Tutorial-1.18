package com.cy4.tutorialmod.datagen.client;

import com.cy4.tutorialmod.TutorialMod;
import com.cy4.tutorialmod.init.BlockInit;
import com.cy4.tutorialmod.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, TutorialMod.MOD_ID, helper);
	}

	protected void simpleBlockItem(Item item) {
		getBuilder(item.getRegistryName().toString())
				.parent(getExistingFile(modLoc("block/" + item.getRegistryName().getPath())));
	}

	protected void oneLayerItem(Item item, ResourceLocation texture) {
		ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
		if (existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")) {
			getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/generated")))
					.texture("layer0", itemTexture);
		} else {
			System.out.println(
					"Texture for " + item.getRegistryName().toString() + " not present at " + itemTexture.toString());
		}
	}
	
	protected void oneLayerItem(Item item) {
		oneLayerItem(item, item.getRegistryName());
	}

	@Override
	protected void registerModels() {
		
		// Block Items
		simpleBlockItem(BlockInit.EXAMPLE_BLOCK.get().asItem());
		simpleBlockItem(BlockInit.ROTATABLE_BLOCK.get().asItem());
		
		// Simple Items
		oneLayerItem(ItemInit.EXAMPLE_ITEM.get());
	}

}
