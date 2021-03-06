package com.example.androidlocalization.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidlocalization.R
import com.example.androidlocalization.managers.LocaleManager
//import com.example.androidlocalization.managers.LocaleHelper
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        LocaleManager(this).setLocale(this)
//        LocaleHelper.setLocale(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        Timber.d("onCreate: Inside MainActivity!")
    }

    private fun initViews() {
        val btnHome: Button = findViewById(R.id.btn_home)
        btnHome.setOnClickListener {
            callLanguageActivity()
        }

        val btnSharedPrefs: Button = findViewById(R.id.btn_sharedPrefs)
        btnSharedPrefs.setOnClickListener {
            callSharedPreferencesActivity()
        }
    }

    private fun callSharedPreferencesActivity() {
        val intent = Intent(this, SharedPreferencesActivity::class.java)
        startActivity(intent)
    }

    private fun callLanguageActivity() {
        val intent = Intent(this, LanguageActivity::class.java)
        startActivity(intent)
    }
}