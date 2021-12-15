package me.ryleu.mindful_eating.mixin;

import me.ryleu.mindful_eating.ExhaustionSources;
import me.ryleu.mindful_eating.FoodGroups;
import me.ryleu.mindful_eating.MindfulEating;
import me.ryleu.mindful_eating.mixin_handlers.HungerManagerHandler;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HungerManager.class)
public class HungerManagerMixin {
    public Item mostRecentFood = Items.AIR;
    public ExhaustionSources lastExhaustionSource = ExhaustionSources.NONE;

    @ModifyArg(method = "update(Lnet/minecraft/entity/player/PlayerEntity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/HungerManager;addExhaustion(F)V"), index = 0)
    private float add(float originalExhaustion) {
        return HungerManagerHandler.handleAddExhaustion(this, originalExhaustion);
    }

    @Inject(method = "eat", at = @At("HEAD"))
    private void eat(Item item, ItemStack stack, CallbackInfo ci) {
        if (item.isFood()) {
            mostRecentFood = item;
            MindfulEating.LOGGER.info("Food eaten: " + FoodGroups.findGroup(item));
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    private void readNbt(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("foodLevel", 99)) {
            mostRecentFood = Registry.ITEM.get(new Identifier(nbt.getString("mostRecentFood")));
            lastExhaustionSource = ExhaustionSources.fromString(nbt.getString("lastExhaustionSource"));
        }
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    private void writeNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putString("mostRecentFood", Registry.ITEM.getId(mostRecentFood).toString());
        if (lastExhaustionSource != ExhaustionSources.NONE) {
            nbt.putString("lastExhaustionSource", lastExhaustionSource.toString());
        }
    }
}