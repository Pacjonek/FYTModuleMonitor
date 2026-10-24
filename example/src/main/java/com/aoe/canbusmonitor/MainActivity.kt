package com.aoe.canbusmonitor

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aoe.fytcanbusmonitor.IModuleCallback
import com.aoe.fytcanbusmonitor.ModuleCodes.MODULE_CODE_MAIN
import com.aoe.fytcanbusmonitor.ModuleCodes.MODULE_CODE_BT
import com.aoe.fytcanbusmonitor.ModuleCodes.MODULE_CODE_CANBUS
import com.aoe.fytcanbusmonitor.MainCommandCodes
import com.aoe.fytcanbusmonitor.CanbusUpdateCodes
import com.aoe.fytcanbusmonitor.MsConnector.Companion.instance as msConnectorInstance
import com.google.android.material.color.DynamicColors
import java.util.concurrent.ConcurrentHashMap
import android.widget.TextView
import android.widget.ScrollView
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.graphics.Typeface
import android.graphics.Color
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import androidx.annotation.ColorInt
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {

    private lateinit var scrollView: ScrollView
    private lateinit var logView: TextView

    private val lastPayloads = ConcurrentHashMap<String, String>()
    private val payloadLock = Any()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DynamicColors.applyToActivitiesIfAvailable(this.application)
        setContentView(R.layout.activity_main)

        scrollView = findViewById(R.id.scroll_view)
        logView = findViewById(R.id.text_view)
        // A focused selectable TextView holds a cursor that follows text appended at
        // the end and forces the ScrollView to scroll to it on every insert. Keep it
        // unfocused in touch mode so taps can't place a cursor (selection still works).
        logView.isFocusableInTouchMode = false

        val connectedMessage = "--- CONNECTED SUCCESSFULLY ---"
        IPCConnection(
            MODULE_CODE_MAIN,
            loggingCallback(MODULE_CODE_MAIN.toLong(), "MAIN", "#2E7D32".toColorInt()),
            (0..76) + (78..100) + (102..178) + (180..256),
            { mainController ->
                appendLogLine("MAIN", "#2E7D32".toColorInt(), connectedMessage)
                // mainController.cmd(42, 1)
                mainController.cmd(
                    MainCommandCodes.C_PLAYBACK_PARAMS,
                    intArrayOf(10, 0),
                    null,
                    arrayOf("Skręć w lewo")
                )
                mainController.cmd(201, intArrayOf(0, 1))
                mainController.cmd(201, intArrayOf(10, 1))
                // mainController.cmd(201, intArrayOf(4, 1))
                // mainController.cmd(201, intArrayOf(8, 1))
                // LOG1 - LOG4
                mainController.cmd(201, intArrayOf(11, 1))
                mainController.cmd(201, intArrayOf(12, 1))
                mainController.cmd(201, intArrayOf(13, 1))
                mainController.cmd(201, intArrayOf(14, 1))

            }
        )
        IPCConnection(
            MODULE_CODE_BT,
            loggingCallback(MODULE_CODE_BT.toLong(), "BT", "#1565C0".toColorInt()),
            (0..100),
            {
                appendLogLine("    BT", "#1565C0".toColorInt(), connectedMessage)
            }
        )
        IPCConnection(
            MODULE_CODE_CANBUS,
            loggingCallback(MODULE_CODE_CANBUS.toLong(), "CANBUS", "#C62828".toColorInt()),
            (0..9) + (98..177) + (0..300) + (1000..1032) + (1034..1200),
            { canbusController ->
                appendLogLine("CANBUS", "#C62828".toColorInt(), connectedMessage)
                canbusController.cmd(1010, 1000)
//                moduleController.cmd(1010, 1000)
//                moduleController.cmd(1035, 1)
//                moduleController.cmd(U_CAR_LIGHT_ENABLED, 1)
//                moduleController.cmd(U_CAR_LIGHT, 1)
//                moduleController.cmd(536, 1)
//                moduleController.cmd(537, 1)
//                moduleController.cmd(538, 1)
//                moduleController.cmd(539, 1)
//                moduleController.cmd(512, 666)
//                moduleController.cmd(513, 666)
//                moduleController.cmd(514, 1)
//                moduleController.cmd(515, 1)
            }
        )
        // IPCConnection(MODULE_CODE_OBD, ModuleController(), loggingCallback(MODULE_CODE_OBD.toLong(), "OBD"), 1000..1200)
        // IPCConnection(MODULE_CODE_BT, DataProxy.btProxy, loggingCallback(MODULE_CODE_BT.toLong(), "BT"), 0..30)

        msConnectorInstance.connect(this)
    }

    private fun loggingCallback(moduleId: Long, moduleName: String, @ColorInt moduleColor: Int) =
        object : IModuleCallback.Stub() {
            override fun update(
                ints: IntArray?,
                flts: FloatArray?,
                strs: Array<String?>?,
                updateCode: Int
            ) {

                val droppedInts: IntArray? =
                    if (ints != null && updateCode == CanbusUpdateCodes.U_CANBUS_TO_SERVICE_UI_FRAME && ints.size > 3) {
                        ints.drop(2).dropLast(1).toIntArray()
                    } else {
                        ints
                    }

                val values = formatPayloadValues(droppedInts, flts, strs)
                logIfChanged(updateCode, values, moduleId, moduleName, moduleColor)
            }
        }

    private fun formatPayloadValues(
        ints: IntArray?,
        flts: FloatArray?,
        strs: Array<String?>?
    ): String {
        val intsBitwise = if (ints?.any { it > 0 && it != (it and 255) } == true) {
            ints.map { it and 255 }
        } else {
            null
        }
        val combined = buildList<Any?> {
            ints?.forEach { add(it) }
            if (intsBitwise != null) {
                add(" //&")
                intsBitwise.forEach { add(it) }
            }
            flts?.forEach { add(it) }
            strs?.forEach { add(it) }
        }
        return combined.joinToString(", ", "[", "]")
    }

    private fun logIfChanged(
        updateCode: Int,
        payloadValues: String,
        moduleId: Long,
        moduleName: String,
        @ColorInt tagColor: Int
    ) {
        val key = "$moduleName:$updateCode"
        val shouldLog = synchronized(payloadLock) {
            val previousValues = lastPayloads.put(key, payloadValues)
            previousValues != payloadValues
        }
        if (shouldLog) {
            val label = UpdateCodeLabelResolver.resolveOrFallback(moduleId, updateCode)
            if (label == updateCode.toString() && payloadValues == "[0]") {
                return
            }
            appendLogLine(moduleName, tagColor, "[$label] $payloadValues")
        }
    }

    private fun appendLogLine(tag: String, @ColorInt tagColor: Int, message: String) {
        Log.i("FYT/$tag", message)
        runOnUiThread {
            val shouldAutoScroll = isScrolledToBottom()
            val scrollYBefore = scrollView.scrollY

            val cleared = clearLogIfNeeded()
            if (cleared) {
                scrollView.scrollTo(0, 0)
            }

            val line = SpannableStringBuilder(tag)
            line.setSpan(
                BackgroundColorSpan(tagColor),
                0,
                tag.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            line.setSpan(
                ForegroundColorSpan(Color.WHITE),
                0,
                tag.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            line.setSpan(StyleSpan(Typeface.BOLD), 0, tag.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            line.append(' ').append(message).append('\n')
            logView.append(line)

            scrollView.post {
                // Auto-scroll only if the view was at the bottom and the user has
                // not scrolled up since this line was appended.
                if (shouldAutoScroll && scrollView.scrollY >= scrollYBefore) {
                    scrollToBottom()
                }
            }
        }
    }

    private fun isScrolledToBottom(): Boolean = !scrollView.canScrollVertically(1)

    /**
     * Scrolls instantly to the very bottom. Unlike [ScrollView.fullScroll], this does
     * not move focus (which would place a cursor at the end of the text and make the
     * framework auto-scroll to it on every append) and does not animate.
     */
    private fun scrollToBottom() {
        val child = scrollView.getChildAt(0) ?: return
        scrollView.scrollTo(0, (child.height - scrollView.height).coerceAtLeast(0))
    }

    /**
     * Removes the oldest lines when the log grows too large.
     * @return true if any text was cleared, false otherwise.
     */
    private fun clearLogIfNeeded(): Boolean {
        val text = logView.editableText ?: return false
        if (text.length <= MAX_LOG_CHARS) return false

        text.clear()
        return true
    }

    private companion object {
        const val MAX_LOG_CHARS = 35_000
    }
}
