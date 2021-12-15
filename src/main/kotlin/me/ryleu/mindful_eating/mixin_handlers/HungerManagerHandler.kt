package me.ryleu.mindful_eating.mixin_handlers

import me.ryleu.mindful_eating.ExhaustionSources
import me.ryleu.mindful_eating.FoodGroups
import me.ryleu.mindful_eating.foodGroups
import me.ryleu.mindful_eating.mixin.HungerManagerMixin

object HungerManagerHandler {
    @JvmStatic fun handleAddExhaustion(mixin: HungerManagerMixin, originalExhaustion: Float): Float {
        val groups = mixin.mostRecentFood.foodGroups
        return originalExhaustion * when (mixin.lastExhaustionSource) {
            ExhaustionSources.SWIM -> if (groups.contains(FoodGroups.FRUITS)) .75f else 1f
            ExhaustionSources.SPRINT -> TODO()
            ExhaustionSources.JUMP -> TODO()
            ExhaustionSources.MINE -> TODO()
            ExhaustionSources.ATTACK -> TODO()
            ExhaustionSources.HURT -> TODO()
            ExhaustionSources.HEAL -> TODO()
            ExhaustionSources.EFFECT -> TODO()
            ExhaustionSources.NONE -> TODO()
            else -> 1f
        }
    }
}