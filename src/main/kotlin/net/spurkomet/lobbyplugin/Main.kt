package net.spurkomet.lobbyplugin

import net.axay.kspigot.chat.col
import net.axay.kspigot.commands.register
import net.axay.kspigot.main.KSpigot
import net.spurkomet.lobbyplugin.listener.joinListener
import net.spurkomet.lobbyplugin.listener.quitListener
import net.spurkomet.lobbyplugin.utils.Fliegen
import net.spurkomet.lobbyplugin.utils.alowFlight
import net.spurkomet.lobbyplugin.utils.noDamige

class InternalMainClass : KSpigot() {

    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }


    override fun load() {
        INSTANCE = this
    }
    override fun startup() {
        joinListener()
        quitListener()
        alowFlight()
        noDamige()
        Fliegen.register()
    }
    override fun shutdown() { }
}
fun getPrefix(): String{
    return "${col("dark_gray")}[${col("dark_aqua")}Lobby${col("dark_gray")}] ${col("white")}"
}