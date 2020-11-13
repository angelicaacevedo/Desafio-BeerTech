package com.example.desafio.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "produto_base_info")
data class Produto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("produto")
    val produto: String,
    @SerializedName( "descricao")
    val descricao: String,
    @SerializedName( "preco")
    val preco: Float,
    @SerializedName( "desconto")
    val desconto: Boolean,
    @SerializedName("imagem")
    val imagem: String
)
