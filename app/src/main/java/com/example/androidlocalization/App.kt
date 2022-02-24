package com.example.androidlocalization

import android.app.Application
import com.example.androidlocalization.managers.LocaleManager
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import timber.log.Timber

class App : Application() {

    companion object {
        var instance: App? = null
        var localManager: LocaleManager? = null
    }

    override fun onCreate() {
        super.onCreate()
        setUpTimber()

        instance = this
        localManager = LocaleManager(this)
        localManager!!.setLocale(this)
    }

    private fun setUpTimber() { // used by -> https://github.com/androiddevnotesyoutube/pretty-timber-android-logcat

        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(true) // (Optional) Whether to show thread info or not. Default true
            .methodCount(1) // (Optional) How many method line to show. Default 2
            .methodOffset(5) // Set methodOffset to 5 in order to hide internal method calls
            .tag("@@@") // To replace the default PRETTY_LOGGER tag with a dash (-).
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

        Timber.plant(object : Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                Logger.log(priority, tag, message, t)
            }
        })
    }

}