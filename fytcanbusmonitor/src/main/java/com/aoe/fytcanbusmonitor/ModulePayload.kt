package com.aoe.fytcanbusmonitor

class ModulePayload(
    val targetCode: Int = -1,
    var ints: IntArray? = null,
    var flts: FloatArray? = null,
    var strs: Array<String?>? = null,
    var moduleId: Int = -1,
    )