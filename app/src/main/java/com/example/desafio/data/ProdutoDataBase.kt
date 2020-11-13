package com.example.desafio.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.desafio.entity.Produto
import kotlinx.coroutines.CoroutineScope


@Database(entities = [Produto::class], version = 1, exportSchema = false)
abstract class ProdutoDataBase: RoomDatabase() {

    abstract fun ProdutoDAO(): ProdutoDAO

    companion object {
        @Volatile
        private var INSTANCE: ProdutoDataBase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ProdutoDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProdutoDataBase::class.java,
                    "learned_item_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}