package com.mhz.harmony_os_version

import android.text.TextUtils
import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result


/** HarmonyOsVersionPlugin */
class HarmonyOsVersionPlugin : FlutterPlugin, MethodCallHandler {
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private lateinit var channel: MethodChannel

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "harmony_os_version")
        channel.setMethodCallHandler(this)
    }

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        if (call.method == "osVersion") {
            if (isHarmonyOs()) {
                result.success(getHarmonyVersion())
            } else {
                result.success(null)
            }
        } else {
            result.notImplemented()
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    /**
     * 是否为鸿蒙系统
     *
     * @return true为鸿蒙系统
     */
    private fun isHarmonyOs(): Boolean {
        return try {
            val buildExClass = Class.forName("com.huawei.system.BuildEx")
            val osBrand = buildExClass.getMethod("getOsBrand").invoke(buildExClass)
            "harmony".equals(osBrand?.toString(), ignoreCase = true)
        } catch (x: Throwable) {
            false
        }
    }

    /**
     * 获取鸿蒙系统版本号
     *
     * @return 版本号
     */
    private fun getHarmonyVersion(): String? {
        return getProp("hw_sc.build.platform.version", "")
    }

    private fun getProp(property: String, defaultValue: String): String? {
        try {
            val spClz = Class.forName("android.os.SystemProperties")
            val method = spClz.getDeclaredMethod("get", String::class.java)
            val value = method.invoke(spClz, property) as String
            return if (TextUtils.isEmpty(value)) {
                defaultValue
            } else value
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        return defaultValue
    }
}
