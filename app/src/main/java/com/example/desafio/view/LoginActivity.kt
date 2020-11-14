package com.example.desafio.view

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio.R
import com.example.desafio.entity.Login
import com.example.desafio.network.ApiServiceBuilder
import com.example.desafio.network.LoginApiService
import com.example.desafio.network.buildService
import com.example.desafio.network.buildService.RETROFIT_SERVICE_BUILDER

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val playButton = findViewById<Button>(R.id.btn_login)
        playButton.setOnClickListener{
            var playUser = findViewById<EditText>(R.id.user_inputText).text.toString()
            var playPassword = findViewById<EditText>(R.id.password_inputText).text.toString()
            var intent = Intent(this, MainActivity::class.java)

            val loginApiService = LoginApiService(RETROFIT_SERVICE_BUILDER)
            val loginInfo = Login(login = playUser, senha = playPassword, resposta = null)
            loginApiService.postLoginToRemote(loginInfo) {

                if (it?.resposta == "Sucesso") {
                    startActivity(intent)
                } else {
                    findViewById<TextView>(R.id.messageErro).visibility = (View.VISIBLE)
                }
            }

        }

    }
}
