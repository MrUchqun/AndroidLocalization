package com.example.androidlocalization.managers

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    companion object {

        private const val DATA_TYPE_STRING = 0
        private const val DATA_TYPE_INT = 1
        private const val DATA_TYPE_LONG = 2
        private const val DATA_TYPE_DOUBLE = 3
        private const val DATA_TYPE_BOOLEAN = 4

        private var prefsManager: PrefsManager? = null

        fun getInstance(context: Context): PrefsManager? {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager
        }

    }

    fun saveData(key: String?, value: String?) {
        val prefsEditor = sharedPreferences.edit()
        prefsEditor.apply {
            when (checkDataType(value!!)) {
                DATA_TYPE_BOOLEAN -> putBoolean(key, value.toBoolean())
                DATA_TYPE_INT -> putInt(key, value.toInt())
                DATA_TYPE_LONG -> putLong(key, value.toLong())
                DATA_TYPE_DOUBLE -> putDouble(key, value.toDouble())
                else -> putString(key, value)
            }
        }
        prefsEditor.apply()
    }

    fun checkDataType(text: String): Int {
        return when {
            text.toBooleanStrictOrNull() != null -> DATA_TYPE_BOOLEAN
            text.toIntOrNull() != null -> DATA_TYPE_INT
            text.toLongOrNull() != null -> DATA_TYPE_LONG
            text.toDoubleOrNull() != null -> DATA_TYPE_DOUBLE
            else -> DATA_TYPE_STRING
        }
    }

    fun getData(key: String?): String? {
        return sharedPreferences.getString(key, "en")
    }

    fun SharedPreferences.Editor.putDouble(key: String?, value: Double?) {
        putString(key, value!!.toString())
    }

    fun SharedPreferences.getDouble(key: String?): Double {
        return getString(key, "0.0")!!.toDouble()
    }

    /* fun setLang(lang: String?) {
        val editor = sharedPreferences.edit()
        editor.putString("lang", lang!!)
        editor.apply()
    }

    fun getLang(): String {
        return sharedPreferences.getString("lang", "")?:""
    }*/
}