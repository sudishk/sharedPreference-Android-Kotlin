package com.edugaon.sharepref

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val doNotHaveAnAccount = findViewById<TextView>(R.id.do_not_have_account_textView)

        val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE )
        val name = sharedPreferences.getString("name_key", "")
        val email = sharedPreferences.getString("email_key", "")
        val password = sharedPreferences.getString("password_key", "")

        loginButton.setOnClickListener {

            if (emailEditText.text.toString() == email && passwordEditText.text.toString() == password){ // comparing email and password editText value to sharedPref value

                sharedPreferences.edit().putBoolean("login_status_key", true).apply() // saving  login_status in shared Pref

                Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show()
                val  intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this, "Invalid email and password", Toast.LENGTH_SHORT).show()

            }
        }

        doNotHaveAnAccount.setOnClickListener {

            val  intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}