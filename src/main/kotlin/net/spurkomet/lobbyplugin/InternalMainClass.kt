package net.spurkomet.lobbyplugin

import net.axay.kspigot.chat.col
import net.axay.kspigot.main.KSpigot

class InternalMainClass : KSpigot() {

    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }


    override fun load() {
        INSTANCE = this
    }
    override fun startup() {
    }

    override fun shutdown() { }
}
fun getPrefix(): String{
    return "${col("dark_gray")}[${col("dark_aqua")}Lobby${col("dark_gray")}] ${col("white")}"
}