package com.cy4.tutorialmod.datagen.server;

import java.util.function.Consumer;

import com.cy4.tutorialmod.TutorialMod;
import com.cy4.tutorialmod.init.BlockInit;
import com.cy4.tutorialmod.init.ItemInit;
import com.cy4.tutorialmod.init.TagInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		// Shaped Recipes
		ShapedRecipeBuilder.shaped(ItemInit.EXAMPLE_ITEM.get(), 10)
			.define('a', BlockInit.EXAMPLE_BLOCK.get().asItem())
			.define('b', TagInit.Items.COOL_ITEMS).pattern("aba").pattern("bab").pattern("aba")
			.unlockedBy("has_" + BlockInit.EXAMPLE_BLOCK.get().getRegistryName().getPath(), has(BlockInit.EXAMPLE_BLOCK.get().asItem()))
			.save(consumer, new ResourceLocation(TutorialMod.MOD_ID,
						ItemInit.EXAMPLE_ITEM.get().getRegistryName().getPath()));
		
		// Shapeless Recipe
		ShapelessRecipeBuilder.shapeless(BlockInit.EXAMPLE_BLOCK.get().asItem(), 4)
			.requires(ItemInit.EXAMPLE_ITEM.get())
			.requires(ItemInit.EXAMPLE_ITEM.get())
			.requires(ItemInit.EXAMPLE_ITEM.get())
			.requires(Items.DIAMOND)
			.unlockedBy("has_" + ItemInit.EXAMPLE_ITEM.get().getRegistryName().getPath(), has(ItemInit.EXAMPLE_ITEM.get()))
			.save(consumer, new ResourceLocation(TutorialMod.MOD_ID,
					BlockInit.EXAMPLE_BLOCK.get().getRegistryName().getPath()));
		
		// Cooking Recipe
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockInit.ROTATABLE_BLOCK.get().asItem()),
				ItemInit.EXAMPLE_ITEM.get(), 1f, 200)
		.unlockedBy("has_" + BlockInit.ROTATABLE_BLOCK.get().getRegistryName().getPath(), has(BlockInit.ROTATABLE_BLOCK.get().asItem()))
		.save(consumer, new ResourceLocation(TutorialMod.MOD_ID,
						ItemInit.EXAMPLE_ITEM.get().getRegistryName().getPath() + "_smelting"));
		
	}

}
