package seq.sequencermod;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import seq.sequencermod.screen.ModScreenHandlers;
import seq.sequencermod.screen.SequencerScreen;

public class SequencerModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HandledScreens.register(ModScreenHandlers.SEQUENCER_SCREEN_HANDLER, SequencerScreen::new);
	}
}