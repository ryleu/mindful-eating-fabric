package me.ryleu.mindful_eating

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class MindfulEating: ModInitializer {
    /**
     * Runs the mod initializer.
     */
    override fun onInitialize() {
        // nothing to do here
    }

    companion object {
        val modid = "mindfuleating"
        val MINDFUL_EATING_ICONS = Identifier(modid, "textures/gui/hunger_icons.png")
        @JvmField val LOGGER: Logger = LogManager.getLogger(modid)
    }
}