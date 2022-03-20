package com.cy4.tutorialmod.init;

import java.util.function.Function;

import com.cy4.tutorialmod.TutorialMod;
import com.cy4.tutorialmod.block.ExampleBlock;
import com.cy4.tutorialmod.block.RotatableBlock;
import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			TutorialMod.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

	public static final RegistryObject<Block> EXAMPLE_BLOCK = register("example_block",
			() -> new ExampleBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE)
					.strength(3.0f, 2.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()
					.emissiveRendering((state, getter, pos) -> {
						return pos.getX() == 50;
					}).lightLevel(state -> 4)),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TutorialMod.TUTORIAL_TAB)));

	public static final RegistryObject<Block> ROTATABLE_BLOCK = register("rotatable_block",
			() -> new RotatableBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).dynamicShape().sound(SoundType.STONE)),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TutorialMod.TUTORIAL_TAB)));

	private static <T extends Block> RegistryObject<T> registerBlock(final String name,
			final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}

	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
			Function<RegistryObject<T>, Supplier<? extends Item>> item) {
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}
}
