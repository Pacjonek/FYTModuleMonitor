package com.aoe.canbusmonitor

import android.os.RemoteException
import com.aoe.fytcanbusmonitor.IConnectionObserver
import com.aoe.fytcanbusmonitor.IModuleCallback
import com.aoe.fytcanbusmonitor.IRemoteToolkit
import com.aoe.fytcanbusmonitor.MsConnector
import com.aoe.fytcanbusmonitor.ModuleCommander

/**
 * Connect to the remote module [moduleId], registering
 * [updateObserver] for every update code in [updateCodes].
 *
 * Self-registers with [MsConnector] and stays registered until
 * [close] is called. Reconnection is handled by MsConnector.
 */
class IPCConnection(
    private val moduleId: Int,
    private val updateListener: IModuleCallback,
    updateCodes: Iterable<Int>
) : IConnectionObserver {
    private val connector = MsConnector.instance
    private val commander = ModuleCommander()
    private val updateCodes = updateCodes.toList()
    private var updateObserverRegistered = false

    init {
        connector.addObserver(this)
    }

    override fun onConnected(toolkit: IRemoteToolkit) {
        if (updateObserverRegistered) {
            onDisconnected()
        }
        try {
            val module = toolkit.getRemoteModule(moduleId)
            //module?.cmd(1043, intArrayOf(1), null, null)
            commander.commanderService = module
        } catch (e: RemoteException) {
            e.printStackTrace()
            return
        }
        updateCodes.forEach { commander.register(updateListener, it, 1) }
        updateObserverRegistered = true
    }

    override fun onDisconnected() {
        if (updateObserverRegistered) {
            updateCodes.forEach { commander.unregister(updateListener, it) }
            updateObserverRegistered = false
        }
        commander.commanderService = null
    }

    fun close() {
        onDisconnected()
        connector.removeObserver(this)
    }
}
