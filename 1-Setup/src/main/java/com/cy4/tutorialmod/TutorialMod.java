package com.cy4.tutorialmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("tutorialmod")
public class TutorialMod {
	
	public TutorialMod() {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
