package com.aoe.fytcanbusmonitor

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import java.util.Random

/**
 * Singleton [ServiceConnection] that maintains a connection to the FYT
 * toolkit service (`com.syu.ms`) and notifies [IConnectionObserver]s.
 */
class MsConnector private constructor() : ServiceConnection {

    var toolkitProxy: IRemoteToolkit? = null
        private set
    private var connecting = false

    /**
     * Connection observers (listeners)
     */
    private val observers = ArrayList<IConnectionObserver>()
    private val connectionTask = object : Runnable {
        override fun run() {
            if (toolkitProxy != null) {
                connecting = false
                return
            }
            val intent = Intent(TOOLKIT_ACTION).setComponent(TOOLKIT_COMPONENT)
            context?.bindService(intent, this@MsConnector, Context.BIND_AUTO_CREATE)
            handler.postDelayed(this, getNextConnectionInterval())
        }
    }

    private var context: Context? = null
    private val handler = Handler(Looper.getMainLooper())

    @Synchronized
    fun connect(context: Context) = connect(context, 0L)

    private fun connect(context: Context, timeoutMillis: Long) {
        if (connecting || toolkitProxy != null) return
        this.context = context.applicationContext
        connecting = true
        handler.postDelayed(connectionTask, timeoutMillis)
    }

    @Synchronized
    override fun onServiceConnected(name: ComponentName, service: IBinder) {
        toolkitProxy = IRemoteToolkit.Stub.asInterface(service)
        val toolkit = toolkitProxy
        if (toolkit != null) {
            observers.forEach { observer -> handler.post { observer.onConnected(toolkit) } }
        }
    }

    @Synchronized
    override fun onServiceDisconnected(name: ComponentName) {
        toolkitProxy = null
        observers.forEach { observer -> handler.post { observer.onDisconnected() } }
        context?.let { connect(it, getNextConnectionInterval()) }
    }

    @Synchronized
    fun addObserver(connectionObserver: IConnectionObserver) {
        if (connectionObserver in observers) return
        observers += connectionObserver
        toolkitProxy?.let { toolkit -> handler.post { connectionObserver.onConnected(toolkit) } }
    }

    @Synchronized
    fun removeObserver(connectionObserver: IConnectionObserver) {
        observers -= connectionObserver
        if (toolkitProxy != null) handler.post { connectionObserver.onDisconnected() }
    }

    @Synchronized
    public fun clearObservers() {
        if (toolkitProxy != null) {
            observers.forEach { observer -> handler.post { observer.onDisconnected() } }
        }
        observers.clear()
    }


    companion object {
        @SuppressLint("StaticFieldLeak")
        val instance = MsConnector()

        private const val TOOLKIT_ACTION = "com.syu.ms.toolkit"
        private val TOOLKIT_COMPONENT = ComponentName("com.syu.ms", "app.ToolkitService")
        private const val RECONNECT_BASE_MS = 1_000
        private const val RECONNECT_JITTER_MS = 2_000
        private fun getNextConnectionInterval(): Long =
            RECONNECT_BASE_MS + Random().nextInt(RECONNECT_JITTER_MS).toLong()
    }
}
