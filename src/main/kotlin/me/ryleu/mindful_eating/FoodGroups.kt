package me.ryleu.mindful_eating

import net.minecraft.item.Item
import net.minecraft.item.Items

enum class FoodGroups(private val members: List<Item>, val exhaustionSources: List<ExhaustionSources>) {
    /*
        Fruit - swimming
        Grains - mining
        Proteins - fighting
        Sugars - healing and the hunger effect
        Veggies - sprinting and jumping
     */
    FRUITS(listOf(
        Items.APPLE,
        Items.CHORUS_FRUIT,
        Items.ENCHANTED_GOLDEN_APPLE,
        Items.GOLDEN_APPLE,
        Items.SWEET_BERRIES,
        Items.GLOW_BERRIES
    ), listOf(
        ExhaustionSources.SWIM
    )),
    GRAINS(listOf(
        Items.BREAD,
        Items.COOKIE,
        Items.PUMPKIN_PIE,
        Items.ENCHANTED_GOLDEN_APPLE
    ), listOf(
        ExhaustionSources.MINE
    )),
    PROTEINS(listOf(
        Items.BEEF,
        Items.CHICKEN,
        Items.COD,
        Items.COOKED_BEEF,
        Items.COOKED_CHICKEN,
        Items.COOKED_COD,
        Items.COOKED_MUTTON,
        Items.COOKED_PORKCHOP,
        Items.COOKED_RABBIT,
        Items.COOKED_SALMON,
        Items.ENCHANTED_GOLDEN_APPLE,
        Items.MUTTON,
        Items.PORKCHOP,
        Items.PUFFERFISH,
        Items.PUMPKIN_PIE,
        Items.ROTTEN_FLESH,
        Items.SALMON,
        Items.SPIDER_EYE,
        Items.TROPICAL_FISH
    )),
    SUGARS(listOf(
        Items.COOKIE,
        Items.ENCHANTED_GOLDEN_APPLE,
        Items.GOLDEN_APPLE,
        Items.GOLDEN_CARROT,
        Items.HONEY_BOTTLE,
        Items.PUMPKIN_PIE
    )),
    VEGETABLES(listOf(
        Items.BAKED_POTATO,
        Items.BEETROOT,
        Items.BEETROOT_SOUP,
        Items.CARROT,
        Items.DRIED_KELP,
        Items.ENCHANTED_GOLDEN_APPLE,
        Items.GOLDEN_CARROT,
        Items.MELON_SLICE,
        Items.MUSHROOM_STEW,
        Items.POISONOUS_POTATO,
        Items.POTATO,
        Items.PUMPKIN_PIE,
        Items.SUSPICIOUS_STEW
    ));

    fun contains(item: Item): Boolean {
        return members.contains(item)
    }

    companion object {
        @JvmStatic fun findGroup(item: Item): List<FoodGroups> {
            val groups: MutableList<FoodGroups> = mutableListOf()
            for (group in values()) {
                if (group.contains(item)) {
                    groups.add(group)
                }
            }
            return groups
        }
    }
}

val Item.foodGroups: List<FoodGroups>
    get() = FoodGroups.findGroup(this)
