package seq.sequencermod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SequencerModTab {
    public static final ItemGroup SEQUENCER_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.SEQUENCER_BLOCK_ITEM)) // иконка — только существующий предмет!
            .displayName(Text.translatable("itemGroup.sequencermod.sequencer_tab"))
            .entries((context, entries) -> {
                entries.add(ModBlocks.SEQUENCER_BLOCK_ITEM); // только зарегистрированные предметы!
            })
            .build();
}