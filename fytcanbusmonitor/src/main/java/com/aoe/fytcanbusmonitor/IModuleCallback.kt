package com.aoe.fytcanbusmonitor

import android.os.Binder
import android.os.IBinder
import android.os.IInterface
import android.os.Parcel
import android.os.RemoteException

/**
 * Minimal replica of the FYT `com.syu.ipc.IModuleCallback` binder interface.
 * Implemented by clients that want module state updates pushed back to them.
 */
interface IModuleCallback : IInterface {

    @Throws(RemoteException::class)
    fun update(message: ModulePayload) {
        // By default, call the old update method, to not break existing implementations
        update(message.ints, message.flts, message.strs, message.targetCode)
    }

    @Throws(RemoteException::class)
    fun update(ints: IntArray?, flts: FloatArray?, strs: Array<String?>?, updateCode: Int = -1){
        // Empty by default to support implementing only update(ModulePayload)
    }

    abstract class Stub : Binder(), IModuleCallback {

        init {
            attachInterface(this, DESCRIPTOR)
        }

        override fun asBinder(): IBinder = this

        @Throws(RemoteException::class)
        public override fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {
            return when (code) {
                TRANSACTION_update -> {
                    data.enforceInterface(DESCRIPTOR)
                    update(ModulePayload(
                        targetCode = data.readInt(),
                        ints = data.createIntArray(),
                        flts = data.createFloatArray(),
                        strs = data.createStringArray(),
                        ))
                    true
                }
                TRANSACTION_getDescriptor -> {
                    reply!!.writeString(DESCRIPTOR)
                    true
                }
                else -> super.onTransact(code, data, reply, flags)
            }
        }

        private class Proxy(private val callbackService: IBinder) : IModuleCallback {
            override fun asBinder(): IBinder = callbackService

            @Throws(RemoteException::class)
            override fun update(ints: IntArray?, flts: FloatArray?, strs: Array<String?>?, updateCode: Int) {
                val data = Parcel.obtain()
                try {
                    data.writeInterfaceToken(DESCRIPTOR)
                    data.writeInt(updateCode)
                    data.writeIntArray(ints)
                    data.writeFloatArray(flts)
                    data.writeStringArray(strs)
                    callbackService.transact(TRANSACTION_update, data, null, FLAG_ONEWAY)
                } finally {
                    data.recycle()
                }
            }
        }

        @Suppress("ConstPropertyName")
        companion object {
            private const val DESCRIPTOR = "com.syu.ipc.IModuleCallback"
            const val TRANSACTION_update = 1
            const val TRANSACTION_getDescriptor = IBinder.INTERFACE_TRANSACTION
            const val UPDATE_SYNC_FLAG = 1

            fun asInterface(obj: IBinder): IModuleCallback {
                return obj.queryLocalInterface(DESCRIPTOR) as? IModuleCallback ?: Proxy(obj)
            }
        }
    }
}