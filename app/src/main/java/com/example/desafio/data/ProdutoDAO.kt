package com.example.desafio.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.desafio.entity.Produto

@Dao
interface ProdutoDAO {
    @Insert
    suspend fun insert(vararg produto: Produto)

    @Query("SELECT * FROM produto_base_info ORDER BY id ASC")
    suspend fun getAll(): List<Produto>
}