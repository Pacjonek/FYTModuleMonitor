package com.aoe.canbusmonitor

import android.os.RemoteException
import com.aoe.fytcanbusmonitor.IConnectionObserver
import com.aoe.fytcanbusmonitor.IModuleCallback
import com.aoe.fytcanbusmonitor.IModuleCallback.Stub.Companion.SYNC_VALUE_FLAG
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
 * [disconnect] is called.
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
    private var updateListenerRegistered = false

    init {
        msConnector.addObserver(this)
    }

    override fun onConnected(toolkit: IRemoteToolkit) {
        if (updateListenerRegistered) {
            onDisconnected()
        }
        var controller: IRemoteModule? = null
        try {
            controller = ModuleController(moduleId, toolkit)
        } catch (e: RemoteException) {
            e.printStackTrace()
            return
        }
        moduleController = controller
        onConnectedListener?.invoke(controller)
        updateCodes.forEach { controller.register(updateListener, it, SYNC_VALUE_FLAG) }
        updateListenerRegistered = true
    }

    override fun onDisconnected() {
        disconnect()
    }

    fun disconnect() {
        val controller = moduleController
        if (controller != null && updateListenerRegistered) {
            updateCodes.forEach { controller.unregister(updateListener, it) }
            updateListenerRegistered = false
        }
        controller?.close()
        msConnector.removeObserver(this)
    }
}
