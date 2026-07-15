package io.github.nobodyasidentity.doomscroll.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractContainerMenu.class)
public abstract class OffhandContainerMixin {

	@Inject(method="clicked(IILnet/minecraft/world/inventory/ContainerInput;Lnet/minecraft/world/entity/player/Player;)V",at=@At("HEAD"),cancellable=true)
	private void doomscroll$blockOffhandInventoryClicks(int slotId,int button,ContainerInput actionType,Player player,CallbackInfo ci){
		if (player==null||slotId<0)return;
		AbstractContainerMenu menu=(AbstractContainerMenu)(Object)this;
		if (slotId<menu.slots.size()){
			Slot slot=menu.getSlot(slotId);
			if (slot.container instanceof Inventory){
				if (slot.getContainerSlot()==Inventory.SLOT_OFFHAND){
					ci.cancel();
				}
			}
		}
	}
}