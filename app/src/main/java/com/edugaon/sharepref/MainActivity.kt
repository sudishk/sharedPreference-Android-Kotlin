package com.edugaon.sharepref

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name_key", "")
//
//        val editPref = sharedPreferences.edit()
//        editPref.putString("name_key", "Sudish kumar")
//        editPref.putString("age_key", "23")
//        editPref.putString("gender_key", "Male")
//            .apply()


        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val showText = findViewById<TextView>(R.id.showNameTextView)
        val saveButton = findViewById<Button>(R.id.saveButton)

        showText.text = name

        saveButton.setOnClickListener {
            showText.text =  nameEditText.text.toString()
            val editPref = sharedPreferences.edit()
            editPref.putString("name_key", nameEditText.text.toString())

                .apply()
        }
    }
}