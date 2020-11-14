package com.example.desafio.network

import android.util.Log
import com.example.desafio.entity.Login
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class LoginApiService(private val loginApiBuilder: ApiServiceBuilder) {

    fun postLoginToRemote(login: Login, onResult:(Login?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = loginApiBuilder.postLogin(login)
                response.enqueue(object : Callback<Login> {

                    override fun onFailure(call: Call<Login>, t: Throwable) {
                        onResult(null)
                    }

                    override fun onResponse(call: Call<Login>, response: Response<Login>) {
                        onResult(response.body())
                    }

                } )

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                }//todo: improve remote access error
            }
        }
    }
}