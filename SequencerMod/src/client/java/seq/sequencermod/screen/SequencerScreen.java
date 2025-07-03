package seq.sequencermod.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import seq.sequencermod.SequencerMod;
import com.mojang.blaze3d.systems.RenderSystem;

public class SequencerScreen extends HandledScreen<SequencerScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(SequencerMod.MOD_ID, "textures/gui/sequencer_gui.png");

    public SequencerScreen(SequencerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        // drawTexture теперь вызывается у context!
        context.drawTexture(TEXTURE, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}