package com.cy4.tutorialmod.init;

import com.cy4.tutorialmod.TutorialMod;
import com.cy4.tutorialmod.item.ExampleItem;
import com.google.common.base.Supplier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			TutorialMod.MOD_ID);

	public static final RegistryObject<Item> EXAMPLE_ITEM = register("example_item",
			() -> new ExampleItem(new Item.Properties().tab(TutorialMod.TUTORIAL_TAB)
					.food(new FoodProperties.Builder().nutrition(4).saturationMod(2.0f)
							.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1f).build())));

	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
}
