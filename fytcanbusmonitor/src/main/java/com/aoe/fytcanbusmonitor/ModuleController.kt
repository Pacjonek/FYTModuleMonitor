package com.aoe.fytcanbusmonitor

import android.os.RemoteException

class ModuleController(override var moduleId: Int, toolkit: IRemoteToolkit) : IRemoteModule.Stub() {
    var moduleProxy: IRemoteModule? = toolkit.getRemoteModule(moduleId)

    override fun cmd(cmdCode: Int, ints: IntArray?, flts: FloatArray?, strs: Array<String?>?) {
        try {
            moduleProxy!!.cmd(cmdCode, ints, flts, strs)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun cmd(cmdCode: Int) {
        try {
            moduleProxy!!.cmd(cmdCode, null, null, null)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun cmd(cmdCode: Int, value: Int) {
        try {
            moduleProxy!!.cmd(cmdCode, intArrayOf(value), null, null)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun cmd(cmdCode: Int, value1: Int, value2: Int) {
        try {
            moduleProxy!!.cmd(cmdCode, intArrayOf(value1, value2), null, null)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    override operator fun get(
        getCode: Int,
        ints: IntArray?,
        flts: FloatArray?,
        strs: Array<String?>?
    ): ModulePayload? {
        val proxy = moduleProxy
        if (proxy != null) {
            try {
                return proxy[getCode, ints, flts, strs]
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }
        return null
    }

    operator fun get(getCode: Int, value: Int): ModulePayload? {
        val proxy = moduleProxy
        return if (proxy != null) {
            try {
                proxy[getCode, intArrayOf(value), null, null]
            } catch (e: RemoteException) {
                e.printStackTrace()
                null
            }
        } else null
    }


    override fun register(updateObserver: IModuleCallback, updateCode: Int, syncFlag: Int) {
        try {
            moduleProxy!!.register(updateObserver, updateCode, syncFlag)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    override fun unregister(updateObserver: IModuleCallback, updateCode: Int) {
        try {
            moduleProxy!!.unregister(updateObserver, updateCode)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun close() {
        moduleProxy = null
    }

}
