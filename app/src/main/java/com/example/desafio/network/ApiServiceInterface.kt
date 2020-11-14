package com.example.desafio.network

import com.example.desafio.entity.Login
import com.example.desafio.entity.Produto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServiceBuilder {
    @GET("produtos")
    fun getProdutos(): Call<List<Produto>>

    @POST("Login")
    fun postLogin(@Body posts: Login?): Call<Login>
}


