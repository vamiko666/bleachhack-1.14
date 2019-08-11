package bleach.hack.module.mods;

import java.util.Arrays;
import java.util.List;

import org.lwjgl.glfw.GLFW;

import bleach.hack.gui.clickgui.SettingBase;
import bleach.hack.gui.clickgui.SettingMode;
import bleach.hack.module.Category;
import bleach.hack.module.Module;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Fullbright extends Module {

	private static List<SettingBase> settings = Arrays.asList(
			new SettingMode(new String[]{"Gamma", "Potion"}, "Mode: "));
			
	public Fullbright() {
		super("Fullbright", GLFW.GLFW_KEY_C, Category.RENDER, "Turns your gamma setting up.", settings);
	}
	
	public void onDisable() {
		mc.options.gamma = 1;
		mc.player.removePotionEffect(StatusEffects.NIGHT_VISION);
	}
	
	public void onUpdate() {
		if(getSettings().get(0).toMode().mode == 0) {
			if(mc.options.gamma < 16) mc.options.gamma += 1.2;
		}else if(getSettings().get(0).toMode().mode == 1) {
			mc.player.addPotionEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1, 5));
		}
	}

}