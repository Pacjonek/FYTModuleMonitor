package com.aoe.canbusmonitor

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aoe.fytcanbusmonitor.IModuleCallback
import com.aoe.fytcanbusmonitor.ModuleCodes.MODULE_CODE_MAIN
import com.aoe.fytcanbusmonitor.ModuleCodes.MODULE_CODE_BT
import com.aoe.fytcanbusmonitor.ModuleCodes.MODULE_CODE_CANBUS
import com.aoe.fytcanbusmonitor.CanbusUpdateCodes.U_CANBUS_FRAME_TO_UI
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
import com.aoe.fytcanbusmonitor.CanbusUpdateCodes.U_CAR_LIGHT
import com.aoe.fytcanbusmonitor.CanbusUpdateCodes.U_CAR_LIGHT_ENABLE

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

        IPCConnection(
            MODULE_CODE_MAIN,
            loggingCallback(MODULE_CODE_MAIN.toLong(), "MAIN", "#2E7D32".toColorInt()),
            (0..76) + (78..178) + (180..256),
            {
                appendLogLine("MAIN", "#2E7D32".toColorInt(), "Connected successfully")
            }
        )
        IPCConnection(
            MODULE_CODE_BT,
            loggingCallback(MODULE_CODE_BT.toLong(), "BT", "#1565C0".toColorInt()),
            (0..100),
            {
                appendLogLine("BT", "#1565C0".toColorInt(), "Connected successfully")
            }
        )
        IPCConnection(
            MODULE_CODE_CANBUS,
            loggingCallback(MODULE_CODE_CANBUS.toLong(), "CANBUS", "#C62828".toColorInt()),
            (0..9) + (98..300) + (500..700) + (1000..1200),
            { moduleController ->
                appendLogLine("CANBUS", "#C62828".toColorInt(), "Connected successfully")
                moduleController.cmd(U_CAR_LIGHT_ENABLE, 1)
                moduleController.cmd(U_CAR_LIGHT, 1)
            }
        )
        // IPCConnection(MODULE_CODE_OBD, ModuleCommander(), loggingCallback(MODULE_CODE_OBD.toLong(), "OBD"), 1000..1200)
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
                    if (ints != null && updateCode == U_CANBUS_FRAME_TO_UI && ints.size > 3) {
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
                add(" //b")
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
        val labelKey = "$moduleName:$updateCode"
        val shouldLog = synchronized(payloadLock) {
            val previousValues = lastPayloads.put(labelKey, payloadValues)
            previousValues != payloadValues
        }
        if (shouldLog) {
            val label = UpdateCodeLabelResolver.resolveOrFallback(moduleId, updateCode)
            appendLogLine(moduleName, tagColor, "[$label] $payloadValues")
        }
    }

    private fun appendLogLine(tag: String, @ColorInt tagColor: Int, message: String) {
        Log.i("FYT/$tag", message)
        runOnUiThread {
            val shouldAutoScroll = isScrolledToBottom()
            val scrollYBefore = scrollView.scrollY

            // Trim before appending so the removed height can be measured against
            // the current layout, then shift the viewport by exactly that amount
            // to keep the visible content steady (unless pinned to the bottom).
            val trimmedHeight = trimLogIfNeeded()
            if (!shouldAutoScroll && trimmedHeight > 0) {
                scrollView.scrollTo(
                    scrollView.scrollX,
                    (scrollView.scrollY - trimmedHeight).coerceAtLeast(0)
                )
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
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN)
                }
            }
        }
    }

    private fun isScrolledToBottom(): Boolean = !scrollView.canScrollVertically(1)

    /**
     * Removes the oldest lines when the log grows too large.
     * @return the height of the removed text in pixels, 0 if nothing was removed.
     */
    private fun trimLogIfNeeded(): Int {
        val text = logView.editableText ?: return 0
        if (text.length <= MAX_LOG_CHARS) return 0

        val excess = text.length - MAX_LOG_CHARS
        val nextNewline = text.indexOf('\n', excess)
        val cutEnd = if (nextNewline >= 0) nextNewline + 1 else excess

        // The layout may lag behind the text during bursts; the removed prefix
        // was laid out long ago, so only clamp for safety.
        val layout = logView.layout
        val removedHeight = if (layout != null && layout.text.isNotEmpty()) {
            val safeOffset = (cutEnd - 1).coerceAtMost(layout.text.length - 1)
            layout.getLineBottom(layout.getLineForOffset(safeOffset))
        } else {
            0
        }

        text.delete(0, cutEnd)
        return removedHeight
    }

    private companion object {
        const val MAX_LOG_CHARS = 50_000
    }
}
