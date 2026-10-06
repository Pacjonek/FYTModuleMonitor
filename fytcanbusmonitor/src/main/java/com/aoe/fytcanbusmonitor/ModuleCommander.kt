package com.aoe.fytcanbusmonitor

import android.os.RemoteException

class ModuleCommander : IRemoteModule.Stub() {
    var commanderService: IRemoteModule? = null

    override fun cmd(cmdCode: Int, ints: IntArray?, flts: FloatArray?, strs: Array<String?>?) {
            try {
                commanderService?.cmd(cmdCode, ints, flts, strs)
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
    }

    fun cmd(cmdCode: Int) {
        try {
            commanderService?.cmd(cmdCode, null, null, null)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun cmd(cmdCode: Int, value: Int) {
        try {
            commanderService?.cmd(cmdCode, intArrayOf(value), null, null)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun cmd(cmdCode: Int, value1: Int, value2: Int) {
            try {
                commanderService?.cmd(cmdCode, intArrayOf(value1, value2), null, null)
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
        val service = commanderService
        if (service != null) {
            try {
                return service[getCode, ints, flts, strs]
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }
        return null
    }

    operator fun get(getCode: Int, value: Int): ModulePayload? {
        val service = commanderService
        return if (service != null) {
            try {
                service[getCode, intArrayOf(value), null, null]
            } catch (e: RemoteException) {
                e.printStackTrace()
                null
            }
        } else null
    }

    fun getI(getCode: Int, fallbackValue: Int): Int? {
        val service = commanderService
        return if (service != null) {
            try {
                val result = service[getCode, null, null, null]
                if (result != null && (result.ints ?: return null).isNotEmpty()) {
                    (result.ints ?: return null).firstOrNull()
                } else fallbackValue
            } catch (e: RemoteException) {
                e.printStackTrace()
                fallbackValue
            }
        } else fallbackValue
    }

    fun getS(getCode: Int, value: Int): String? {
        val service = commanderService
        return if (service != null) {
            try {
                val result = service[getCode, intArrayOf(value), null, null]
                if (result != null && (result.strs ?: return null).isNotEmpty()) {
                    (result.strs ?: return null).firstOrNull()
                } else null
            } catch (e: RemoteException) {
                e.printStackTrace()
                null
            }
        } else null
    }

    fun getS(getCode: Int, value1: Int, value2: Int): String? {
        val service = commanderService
        return if (service != null) {
            try {
                val result = service[getCode, intArrayOf(value1, value2), null, null]
                if (result != null && (result.strs ?: return null).isNotEmpty()) {
                    (result.strs ?: return null).firstOrNull()
                } else null
            } catch (e: RemoteException) {
                e.printStackTrace()
                null
            }
        } else null
    }

    override fun register(updateObserver: IModuleCallback, updateCode: Int, syncFlag: Int) {
            try {
                commanderService?.register(updateObserver, updateCode, syncFlag)
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
    }

    override fun unregister(updateObserver: IModuleCallback, updateCode: Int) {
        try {
            commanderService?.unregister(updateObserver, updateCode)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }
}
