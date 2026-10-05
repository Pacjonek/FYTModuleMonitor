package com.aoe.fytcanbusmonitor

open class ModuleUpdateCallback : IModuleCallback.Stub() {
    var moduleId: Int = -1

    override fun update(message: ModulePayload) {
        message.moduleId = moduleId
        super.update(message)
    }
}