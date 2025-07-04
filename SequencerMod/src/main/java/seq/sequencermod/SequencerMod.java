package seq.sequencermod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import seq.sequencermod.block.SequencerBlock;
import seq.sequencermod.screen.SequencerScreenHandler;
import seq.sequencermod.screen.ModScreenHandlers; // <--- обязательно импортируй!
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequencerMod implements ModInitializer {
	public static final String MOD_ID = "sequencermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Блок и предмет
	public static final Block SEQUENCER_BLOCK = new SequencerBlock();
	public static final Item SEQUENCER_BLOCK_ITEM = new BlockItem(SEQUENCER_BLOCK, new Item.Settings());

	// Креативная вкладка
	public static final ItemGroup SEQUENCER_TAB = FabricItemGroup.builder()
			.icon(() -> new ItemStack(SEQUENCER_BLOCK_ITEM))
			.displayName(Text.translatable("itemGroup.sequencermod.sequencer_tab"))
			.entries((context, entries) -> {
				entries.add(SEQUENCER_BLOCK_ITEM);
			})
			.build();

	@Override
	public void onInitialize() {
		// Регистрация блока и предмета
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "sequencer_block"), SEQUENCER_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sequencer_block"), SEQUENCER_BLOCK_ITEM);

		// Регистрация вкладки
		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "sequencer_tab"), SEQUENCER_TAB);

		// Регистрация ScreenHandler через ModScreenHandlers
		ModScreenHandlers.SEQUENCER_SCREEN_HANDLER = Registry.register(
				Registries.SCREEN_HANDLER,
				new Identifier(MOD_ID, "sequencer_block"),
				new ScreenHandlerType<>(SequencerScreenHandler::new, FeatureFlags.VANILLA_FEATURES)
		);

		LOGGER.info("Hello Fabric world!");
	}
}