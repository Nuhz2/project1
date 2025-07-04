package seq.sequencermod;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {
    // Объявление блока
    public static final Block SEQUENCER_BLOCK = new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f));
    // Объявление BlockItem для блока (чтобы он был предметом!)
    public static final Item SEQUENCER_BLOCK_ITEM = new BlockItem(SEQUENCER_BLOCK, new Item.Settings());

    // Метод регистрации
    public static void registerModBlocks() {
        Registry.register(Registries.BLOCK, new Identifier("sequencermod", "sequencer_block"), SEQUENCER_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("sequencermod", "sequencer_block"), SEQUENCER_BLOCK_ITEM);
    }
}