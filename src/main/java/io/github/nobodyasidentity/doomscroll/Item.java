package io.github.nobodyasidentity.doomscroll;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;

public class Item extends net.minecraft.world.item.Item{
    public static void init(){}
    public Item(net.minecraft.world.item.Item.Properties properties){super(properties);}
    private static <T extends net.minecraft.world.item.Item>T register(String name,T item){return Registry.register(BuiltInRegistries.ITEM,Identifier.fromNamespaceAndPath(Doomscroll.MOD_ID,name),item);}

    public static Item create(String name,net.minecraft.world.item.Item.Properties properties){
        properties.setId(net.minecraft.resources.ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(Doomscroll.MOD_ID,name)));
        Item item=new Item(properties);
        return register(name,item);
    }
}