package com.aoe.fytcanbusmonitor

interface IConnectionObserver {
    fun onConnected(toolkit: IRemoteToolkit)
    fun onDisconnected()
}

@Deprecated(
    message = "Name `ConnectionObserver` in context of the interface is misleading",
    replaceWith = ReplaceWith("IConnectionObserver")
)
typealias ConnectionObserver = IConnectionObserver
