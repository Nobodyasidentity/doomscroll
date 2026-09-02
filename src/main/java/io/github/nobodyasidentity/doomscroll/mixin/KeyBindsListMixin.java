package io.github.nobodyasidentity.doomscroll.mixin;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.KeyMapping;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.nobodyasidentity.doomscroll.Doomscroll;

@Mixin(targets="net.minecraft.client.gui.screens.options.controls.KeyBindsList$KeyEntry")
public class KeyBindsListMixin{
    @Shadow @Final private KeyMapping key;
    @Shadow @Final private Button changeButton;
    @Shadow @Final private Button resetButton;

    @Inject(method="refreshEntry",at=@At("TAIL"))
    private void doomscroll$disableChangeButton(CallbackInfo ci){
        if(this.key!=null&&"key.swapOffhand".equals(this.key.getName())){
            this.changeButton.active=false;
            this.resetButton.active=false;
            this.changeButton.setTooltip(Tooltip.create(Component.translatable("key.swapOffhand.description",Doomscroll.MOD_ID)));
        }
    }
}