package com.aoe.canbusmonitor

import android.os.RemoteException
import com.aoe.fytcanbusmonitor.IConnectionObserver
import com.aoe.fytcanbusmonitor.IModuleCallback
import com.aoe.fytcanbusmonitor.IRemoteToolkit
import com.aoe.fytcanbusmonitor.IRemoteModule
import com.aoe.fytcanbusmonitor.MsConnector.Companion.instance as msConnectorInstance
import com.aoe.fytcanbusmonitor.ModuleController
import com.aoe.fytcanbusmonitor.MsConnector

/**
 * Connect to the remote module [moduleId], registering
 * [updateListener] for every update code in [updateCodes].
 *
 * (Re)connect with [MsConnector] and stays that until
 * [close] is called.
 */
class IPCConnection(
    private val moduleId: Int,
    private val updateListener: IModuleCallback,
    updateCodes: Iterable<Int>,
    private val onConnectedListener: ((moduleController: ModuleController) -> Unit)? = null,
    private val msConnector: MsConnector = msConnectorInstance
) : IConnectionObserver {
    private var moduleController: ModuleController? = null

    private val updateCodes = updateCodes.toList()
    private var updateObserverRegistered = false

    init {
        msConnector.addObserver(this)
    }

    override fun onConnected(toolkit: IRemoteToolkit) {
        if (updateObserverRegistered) {
            onDisconnected()
        }
        var controller: IRemoteModule? = null
        try {
            controller = ModuleController(moduleId, toolkit)
            //module?.cmd(1043, intArrayOf(1), null, null)
        } catch (e: RemoteException) {
            e.printStackTrace()
            return
        }
        onConnectedListener?.invoke(controller)
        updateCodes.forEach { controller.register(updateListener, it, 1) }
        updateObserverRegistered = true
    }

    override fun onDisconnected() {
        val controller = moduleController
        if (controller != null && updateObserverRegistered) {
            updateCodes.forEach { controller.unregister(updateListener, it) }
            updateObserverRegistered = false
        }
        moduleController?.close()
    }

    fun close() {
        onDisconnected()
        msConnector.removeObserver(this)
    }
}
