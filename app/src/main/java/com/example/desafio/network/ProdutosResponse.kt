package com.example.desafio.network

import com.example.desafio.entity.Produto
import com.squareup.moshi.Json

data class ProdutosResponse (
        @Json(name = "produtos")
        val produtosList: List<Produto>)
