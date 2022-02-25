package com.example.androidlocalization.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.androidlocalization.R
import com.example.androidlocalization.managers.PrefsManager
import timber.log.Timber

class SharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        initViews()
    }

    private fun initViews() {
        val etEmail: EditText = findViewById(R.id.et_email)
        val btnSave: Button = findViewById(R.id.btn_save)

        btnSave.setOnClickListener {
            val email = etEmail.text.toString()
            val prefs = PrefsManager.getInstance(this)
            prefs!!.saveDataString("email", email)
        }
    }

}