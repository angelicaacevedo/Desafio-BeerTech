package com.example.desafio.network


import com.example.desafio.entity.Produto
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://private-8f4dda-testeabi.apiary-mock.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ProdutosApiService {
    @GET("produtos")
    fun getProdutos(): Call<List<Produto>>
}

object ProdutosApi {
    val retrofitService: ProdutosApiService by lazy {
        retrofit.create(ProdutosApiService::class.java)
    }
}