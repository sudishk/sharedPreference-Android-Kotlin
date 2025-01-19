package com.edugaon.sharepref

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val  sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)
        val loginStatus = sharedPreferences.getBoolean("login_status_key", false) // getting login status from sharePref based on key


        Handler().postDelayed({
            if (loginStatus){ // checking login
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent) // sending on MainActivity
            }else{
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent) // sending on LoginActivity
            }

            finish()

        }, 3000 /* timer for splash*/)
    }
}