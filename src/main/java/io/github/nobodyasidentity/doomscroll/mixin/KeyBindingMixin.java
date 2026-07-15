package io.github.nobodyasidentity.doomscroll.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(KeyMapping.class)
public class KeyBindingMixin{
    @Shadow private boolean isDown;
    @Shadow private int clickCount;
    private boolean doomscroll$isTargetKey(){
        KeyMapping self=(KeyMapping)(Object)this;
        Minecraft client=Minecraft.getInstance();
        if (client!=null&&client.options!=null){
            return self==client.options.keySwapOffhand;
        }
        return false;
    }
    @Inject(method="isDown",at=@At("HEAD"),cancellable=true)
    private void forceNeverDown(CallbackInfoReturnable<Boolean> cir){
        if (doomscroll$isTargetKey()){
            this.isDown=false;
            cir.setReturnValue(false);
        }
    }
    @Inject(method="consumeClick",at=@At("HEAD"),cancellable=true)
    private void forceNeverClicked(CallbackInfoReturnable<Boolean> cir){
        if (doomscroll$isTargetKey()){
            this.clickCount=0;
            cir.setReturnValue(false);
        }
    }
}