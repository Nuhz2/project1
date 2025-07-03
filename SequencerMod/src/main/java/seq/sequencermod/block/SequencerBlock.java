package seq.sequencermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.text.Text;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerInventory;
import seq.sequencermod.screen.SequencerScreenHandler;

public class SequencerBlock extends Block {
    public SequencerBlock() {
        super(AbstractBlock.Settings.create().strength(2.0f, 3.0f).nonOpaque().noCollision());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            player.openHandledScreen(new NamedScreenHandlerFactory() {
                @Override
                public Text getDisplayName() {
                    return Text.translatable("block.sequencermod.sequencer_block");
                }
                @Override
                public SequencerScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity p) {
                    return new SequencerScreenHandler(syncId, inv);
                }
            });
        }
        return ActionResult.SUCCESS;
    }
}