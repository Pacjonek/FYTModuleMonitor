package com.aoe.canbusmonitor

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aoe.fytcanbusmonitor.IModuleCallback
import com.aoe.fytcanbusmonitor.ModuleCodes.MODULE_CODE_MAIN
import com.aoe.fytcanbusmonitor.ModuleCodes.MODULE_CODE_BT
import com.aoe.fytcanbusmonitor.ModuleCodes.MODULE_CODE_CANBUS
import com.aoe.fytcanbusmonitor.MsConnector
import java.util.concurrent.ConcurrentHashMap

class MainActivity : AppCompatActivity() {

    private val lastPayloads = ConcurrentHashMap<String, String>()
    private val payloadLock = Any()
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        IPCConnection(
            MODULE_CODE_MAIN,
            loggingCallback(MODULE_CODE_MAIN.toLong(), "MAIN"),
            (0..76) + (78..256)
        )
        IPCConnection(
            MODULE_CODE_BT,
            loggingCallback(MODULE_CODE_BT.toLong(), "BT"),
            (0..100)
        )
        IPCConnection(
            MODULE_CODE_CANBUS,
            loggingCallback(MODULE_CODE_CANBUS.toLong(), "CANBUS"),
            (0..9) + (98..300) + (500..700) + (1000..1200)
        )
        // IPCConnection(MODULE_CODE_OBD, ModuleCommander(), loggingCallback(MODULE_CODE_OBD.toLong(), "OBD"), 1000..1200)
        // IPCConnection(MODULE_CODE_BT, DataProxy.btProxy, loggingCallback(MODULE_CODE_BT.toLong(), "BT"), 0..30)

        MsConnector.instance.connect(this)
    }

    private fun loggingCallback(moduleCode: Long, moduleLabel: String) = object : IModuleCallback.Stub() {
        override fun update(
            ints: IntArray?,
            flts: FloatArray?,
            strs: Array<String?>?,
            updatedCode: Int
            ) {
            val values = formatPayloadValues(ints, flts, strs)
            logIfChanged(moduleCode, moduleLabel, updatedCode, values)
        }
    }

    private fun formatPayloadValues(
        intArray: IntArray?,
        floatArray: FloatArray?,
        strArray: Array<String?>?
    ): String {
        val intBitwiseArray = if (intArray?.any { it > 0 && it != (it and 255) } == true) {
            intArray.map { it and 255 }
        } else {
            null
        }
        val combined = buildList<Any?> {
            intArray?.forEach { add(it) }
            if (intBitwiseArray != null) {
                add(" //b")
                intBitwiseArray.forEach { add(it) }
            }
            floatArray?.forEach { add(it) }
            strArray?.forEach { add(it) }
        }
        return combined.joinToString(", ", "[", "]")
    }

    private fun logIfChanged(
        moduleId: Long,
        moduleLabel: String,
        updatedCode: Int,
        data: String
    ) {
        val messageKey = "$moduleLabel:$updatedCode"
        val shouldLog = synchronized(payloadLock) {
            val previousValues = lastPayloads.put(messageKey, data)
            previousValues != data
        }
        if (shouldLog) {
            val codeLabel = UpdateCodeNameResolver.resolveOrFallback(moduleId, updatedCode)
            Log.w("FYT/$moduleLabel", "[$codeLabel] $data")
        }
    }
}
