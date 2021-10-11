package net.spurkomet.lobbyplugin.utils

import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.register
import net.axay.kspigot.commands.runs
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.extensions.pluginManager
import net.axay.kspigot.extensions.server
import net.axay.kspigot.runnables.task
import org.bukkit.GameMode
import org.bukkit.event.player.PlayerGameModeChangeEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

val Fliegen = command("Fliegen"){
    runs { this.player.allowFlight = true }
}

fun alowFlight(){
    listen<PlayerGameModeChangeEvent>(){
        //it.player.allowFlight = true
        if (it.newGameMode == GameMode.SPECTATOR || it.newGameMode == GameMode.CREATIVE) {
            it.player.allowFlight = false
            println(it.player.allowFlight.toString())
        }
        if (it.newGameMode == GameMode.SURVIVAL || it.newGameMode == GameMode.ADVENTURE) {
            it.player.allowFlight = true
            println(it.player.allowFlight.toString())
        }
    }
}
fun noDamige(){
    task (
        sync = true,
        delay = 20,
        period = 20
            ){
        onlinePlayers.forEach {
            it.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 40, 5, false, false, false))
            it.addPotionEffect(PotionEffect(PotionEffectType.SATURATION, 40, 5, false, false, false))
        }
    }
}