package transfarmer.arbitrarypatches.mixin.client.gui.screen.ingame;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import transfarmer.arbitrarypatches.config.Configuration;
import transfarmer.arbitrarypatches.duck.client.gui.screen.ScreenDuck;

@Environment(EnvType.CLIENT)
@Mixin(value = InventoryScreen.class, priority = 5000)
public abstract class InventoryScreenMixin {
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "net/minecraft/client/gui/screen/ingame/InventoryScreen.addButton(Lnet/minecraft/client/gui/widget/AbstractButtonWidget;)Lnet/minecraft/client/gui/widget/AbstractButtonWidget;"))
    public AbstractButtonWidget nulledAddButton(final InventoryScreen screen, final AbstractButtonWidget button) {
        return Configuration.instance().client.hideRecipeBook ? null : ((ScreenDuck) screen).addButton(button);
    }
}
