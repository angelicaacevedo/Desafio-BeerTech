package com.example.desafio.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://private-8f4dda-testeabi.apiary-mock.com/"

object buildService {

    val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    val RETROFIT_SERVICE_BUILDER: ApiServiceBuilder by lazy {
        retrofit.create(ApiServiceBuilder::class.java)
    }
}

