package me.ryleu.mindful_eating.mixin;

import me.ryleu.mindful_eating.mixin_handlers.FoodEatenHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class FoodEatenMixin extends LivingEntity {
    protected FoodEatenMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "eatFood(Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;")
    private void eatFood(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        FoodEatenHandler.handle((PlayerEntity)(Object)this, stack);
    }
}
