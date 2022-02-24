package com.example.androidlocalization.activity

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
//import com.example.androidlocalization.App
import com.example.androidlocalization.Application
import com.example.androidlocalization.R
import com.example.androidlocalization.managers.LocaleHelper
//import com.example.androidlocalization.managers.LocaleManager
import com.example.androidlocalization.managers.PrefsManager
import timber.log.Timber
import java.util.*

class LanguageActivity : AppCompatActivity() {

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocaleHelper.setLocale(this)
        setContentView(R.layout.activity_language)
        Timber.d("onCreate: Inside LanguageActivity!")
        initViews()
    }

    private fun initViews() {
        context = this
        val btnEnglish: Button = findViewById(R.id.btn_english)
        btnEnglish.setOnClickListener {
            PrefsManager(context).setLang("en")
            finish()
        }
        val btnRussian: Button = findViewById(R.id.btn_russian)
        btnRussian.setOnClickListener {
            PrefsManager(context).setLang("ru")
            finish()
        }
        val btnUzbek: Button = findViewById(R.id.btn_uzbek)
        btnUzbek.setOnClickListener {
            PrefsManager(context).setLang("uz")
            finish()
        }

        val one = resources.getQuantityString(R.plurals.my_cats, 1, 1)
        val few = resources.getQuantityString(R.plurals.my_cats, 2, 4)
        val many = resources.getQuantityString(R.plurals.my_cats, 5, 10)

        Timber.d(one)
        Timber.d(few)
        Timber.d(many)
    }

    private fun setLocale(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        finish()
    }
}