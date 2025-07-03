package seq.sequencermod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import seq.sequencermod.block.SequencerBlock;
import seq.sequencermod.screen.ModScreenHandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequencerMod implements ModInitializer {
	public static final String MOD_ID = "sequencermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Block SEQUENCER_BLOCK = new SequencerBlock();

	@Override
	public void onInitialize() {
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "sequencer_block"), SEQUENCER_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sequencer_block"),
				new BlockItem(SEQUENCER_BLOCK, new Item.Settings()));
		ModScreenHandlers.registerAllScreenHandlers();
		LOGGER.info("Hello Fabric world!");
	}
}