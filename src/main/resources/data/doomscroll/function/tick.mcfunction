title @a times 0t 1t 0t
clear @a doomscroll:phone
execute as @a unless entity @s[x_rotation=45..90] run function doomscroll:off_phone
execute as @a if entity @s[x_rotation=45..90] run function doomscroll:on_phone
execute as @a if entity @s[x_rotation=89..90] run function doomscroll:doomscrolling
execute as @a if entity @s[x_rotation=-90] run function doomscroll:neck_break
kill @e[type=minecraft:item,nbt={Item:{id:"doomscroll:phone"}}]