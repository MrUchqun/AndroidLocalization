package com.example.androidlocalization.managers

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    companion object {
        private var prefsManager: PrefsManager? = null
        fun getInstance(context: Context): PrefsManager? {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager
        }
    }

    fun saveDataString(key: String?, value: String?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }

    fun getData(key: String?): String? {
        return sharedPreferences.getString(key, "en")
    }

    fun setLang(lang: String?) {
        val editor = sharedPreferences.edit()
        editor.putString("lang", lang!!)
        editor.apply()
    }

    fun getLang(): String {
        return sharedPreferences.getString("lang", "")?:""
    }
}