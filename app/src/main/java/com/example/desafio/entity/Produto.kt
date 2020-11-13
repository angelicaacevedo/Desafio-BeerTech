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
    val name: String,
    @SerializedName("imagem")
    val thumbUrl: String
)
