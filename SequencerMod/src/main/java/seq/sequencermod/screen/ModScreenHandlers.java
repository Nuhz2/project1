package seq.sequencermod.screen;

import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;

public class ModScreenHandlers {
    public static ScreenHandlerType<SequencerScreenHandler> SEQUENCER_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        SEQUENCER_SCREEN_HANDLER = Registry.register(
                Registries.SCREEN_HANDLER,
                new Identifier("sequencermod", "sequencer_screen_handler"),
                new ScreenHandlerType<>(SequencerScreenHandler::new, FeatureFlags.VANILLA_FEATURES)
        );
    }
}