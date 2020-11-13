package com.example.desafio.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val playButton = findViewById<Button>(R.id.btn_login)
        playButton.setOnClickListener{
            var playUser = findViewById<EditText>(R.id.user_inputText).text.toString()
            var playPassword = findViewById<EditText>(R.id.password_inputText).text.toString()
            var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("playUser", playUser)
                intent.putExtra("playPassword", playPassword)

            startActivity(intent)
        }
    }
}
