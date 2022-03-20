package com.cy4.tutorialmod.init;

import com.cy4.tutorialmod.TutorialMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class TagInit {
	public static final class Blocks {
		
		public static final Tag.Named<Block> COOL_BLOCKS = mod("cool_blocks");
		
		
		private static Tag.Named<Block> mod(String path) {
			return BlockTags.bind(new ResourceLocation(TutorialMod.MOD_ID, path).toString());
		}
		
	}
	
	public static final class Items {
		
		public static final Tag.Named<Item> COOL_ITEMS = mod("cool_items");
		
		private static Tag.Named<Item> mod(String path) {
			return ItemTags.bind(new ResourceLocation(TutorialMod.MOD_ID, path).toString());
		}
		
	}
}
