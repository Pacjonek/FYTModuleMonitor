package com.aoe.fytcanbusmonitor

import android.os.RemoteException

class ModuleController(override var moduleId: Int, toolkit: IRemoteToolkit) : IRemoteModule.Stub() {
    var moduleProxy: IRemoteModule? = toolkit.getRemoteModule(moduleId)

    override fun cmd(cmdCode: Int, ints: IntArray?, flts: FloatArray?, strs: Array<String?>?) {
        moduleProxy!!.cmd(cmdCode, ints, flts, strs)
    }

    fun cmd(cmdCode: Int, value: IntArray) {
        moduleProxy!!.cmd(cmdCode, value, null, null)
    }

    fun cmd(cmdCode: Int, value: Int) {
        moduleProxy!!.cmd(cmdCode, intArrayOf(value), null, null)
    }

    override operator fun get(
        getCode: Int,
        ints: IntArray?,
        flts: FloatArray?,
        strs: Array<String?>?
    ): ModulePayload? {
        return moduleProxy!![getCode, ints, flts, strs]

    }

    operator fun get(getCode: Int, value: Int): ModulePayload? {
        return moduleProxy!![getCode, intArrayOf(value), null, null]
    }


    override fun register(updateObserver: IModuleCallback, updateCode: Int, syncFlag: Int) {
        moduleProxy!!.register(updateObserver, updateCode, syncFlag)
    }

    override fun unregister(updateObserver: IModuleCallback, updateCode: Int) {
        moduleProxy!!.unregister(updateObserver, updateCode)
    }

    fun close() {
        moduleProxy = null
    }

}
