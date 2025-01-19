package com.edugaon.sharepref

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val alreadyHaveAnAccount = findViewById<TextView>(R.id.already_have_account_textView)

        val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE ).edit()

        registerButton.setOnClickListener {

            sharedPreferences.putString("name_key", nameEditText.text.toString())
            sharedPreferences.putString("email_key", emailEditText.text.toString())
            sharedPreferences.putString("password_key", passwordEditText.text.toString())
            sharedPreferences.putBoolean("login_status_key", false)
                .apply()

            val  intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

        }

        alreadyHaveAnAccount.setOnClickListener {

            val  intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}