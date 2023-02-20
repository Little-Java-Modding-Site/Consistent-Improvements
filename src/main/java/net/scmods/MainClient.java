package net.scmods;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.scmods.blocks.gold_hopper.GoldHopperScreen;

@Environment(EnvType.CLIENT)
public class MainClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(Main.GOLD_HOPPER_SCREEN_HANDLER, GoldHopperScreen::new);
    }
}
