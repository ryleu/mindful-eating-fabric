package me.ryleu.mindful_eating

import java.util.*

enum class ExhaustionSources {
    SWIM,
    SPRINT,
    JUMP,
    MINE,
    ATTACK,
    HURT,
    HEAL,
    EFFECT,
    NONE;

    companion object {
        @JvmStatic fun fromString(string: String): ExhaustionSources {
            return when (string.uppercase(Locale.ENGLISH)) {
                "SWIM" -> SWIM
                "SPRINT" -> SPRINT
                "JUMP" -> JUMP
                "MINE" -> MINE
                "ATTACK" -> ATTACK
                "HURT" -> HURT
                "HEAL" -> HEAL
                "EFFECT" -> EFFECT
                else -> NONE
            }
        }
    }
}