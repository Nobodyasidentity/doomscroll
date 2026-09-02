package io.github.nobodyasidentity.doomscroll;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import com.mojang.blaze3d.platform.InputConstants;

public class DoomscrollClient implements ClientModInitializer{
    @Override
    public void onInitializeClient(){
        ClientTickEvents.END_CLIENT_TICK.register(client->{
            if(client.options!=null&&client.options.keySwapOffhand!=null){
                if(!client.options.keySwapOffhand.isUnbound()){
                    client.options.keySwapOffhand.setKey(InputConstants.UNKNOWN);
                    client.options.save();
                }
            }
        });
    }
}