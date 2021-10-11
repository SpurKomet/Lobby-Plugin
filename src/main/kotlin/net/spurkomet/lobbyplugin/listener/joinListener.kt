package net.spurkomet.lobbyplugin.listener

import net.axay.kspigot.chat.col
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.bukkit.title
import org.bukkit.GameMode
import org.bukkit.event.player.PlayerJoinEvent

fun joinListener(){
    listen<PlayerJoinEvent>(){
        it.joinMessage = "${col("dark_gray")}[${col("dark_green")}+${col("dark_gray")}] ${col(if (it.player.isOp)"aqua" else "white")}${it.player.name}"
        it.player.title( "${col("yellow")}Willkommen! ${if(it.player.isOp) col("aqua") else col("white")}${it.player.name}",
            "${col ("dark_aqua")}SUtils Server | powered by ${col("aqua")}Kot${col("white")}lin",
            4, 100, 10)
        it.player.allowFlight = true
        if (it.player.gameMode != GameMode.ADVENTURE){
            it.player.gameMode = GameMode.ADVENTURE
        }
    }
}

