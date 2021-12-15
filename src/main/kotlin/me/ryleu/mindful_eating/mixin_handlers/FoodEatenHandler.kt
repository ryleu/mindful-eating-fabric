package me.ryleu.mindful_eating.mixin_handlers

import me.ryleu.mindful_eating.ExampleMod
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtString

object FoodEatenHandler {
    @JvmStatic fun handle(entity: PlayerEntity, stack: ItemStack) {
        val nbt = NbtCompound()
        val element = NbtString.of(stack.item.name.string)
        nbt.put("lastFood", element)
        entity.writeCustomDataToNbt(nbt)
        ExampleMod.LOGGER.info(stack.item.name.string)
    }
}