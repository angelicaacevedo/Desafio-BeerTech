package com.example.desafio.entity

import com.google.gson.annotations.SerializedName

class Login (

    @SerializedName("login")
    val login: String?,
    @SerializedName("senha")
    val senha: String?,
    @SerializedName("reposta")
    val resposta: String?
)