package seq.sequencermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.text.Text;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import seq.sequencermod.screen.SequencerScreenHandler;

public class SequencerBlock extends Block {
    public SequencerBlock() {
        super(AbstractBlock.Settings.create()
                .strength(1.0f)
                .nonOpaque()
                .noCollision()
        );
    }

    // Не X-ray: блок прозрачный, но не "воздух"
    @Override
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1.0f;
    }

    // Прозрачный рендер
    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    // Нет коллизии — можно проходить сквозь
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    // Открытие GUI по ПКМ
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            player.openHandledScreen(new NamedScreenHandlerFactory() {
                @Override
                public Text getDisplayName() {
                    return Text.translatable("block.sequencermod.sequencer_block");
                }
                @Override
                public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity playerEntity) {
                    return new SequencerScreenHandler(syncId, inv);
                }
            });
        }
        return ActionResult.SUCCESS;
    }
}