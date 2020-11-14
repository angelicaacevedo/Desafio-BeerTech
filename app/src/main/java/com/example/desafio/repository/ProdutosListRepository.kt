package com.example.desafio.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.desafio.data.ProdutoDAO
import com.example.desafio.entity.Produto
import com.example.desafio.network.ApiServiceBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class ProdutosListRepository(private val ProdutoDAO: ProdutoDAO,
                             private val produtoApiBuilder: ApiServiceBuilder
) {
    private val produtoListResponse = MutableLiveData<List<Produto>>()

    val produtosList: LiveData<List<Produto>>
    get() = produtoListResponse

    init {
        getProdutos()
    }

    private fun getProdutos() {
        CoroutineScope(Dispatchers.IO).launch {
            val listFromDB = ProdutoDAO.getAll()
            if(listFromDB.isNotEmpty()) {
                produtoListResponse.postValue(listFromDB)
            } else {
                getProdutosFromRemote()
            }
        }
    }

    private fun getProdutosFromRemote() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val listResult = produtoApiBuilder.getProdutos()

                listResult.enqueue(object : Callback<List<Produto>> {

                    override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                        Log.d("STATE", "ERROR $call | $t")
                    }

                    override fun onResponse(call: Call<List<Produto>>, response: Response<List<Produto>>) {
                        saveRemoteDataAtDatabase(response.body()!!)
                        produtoListResponse.postValue(response.body())
                    }

                } )

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    produtoListResponse.postValue(listOf())
                }//todo: improve remote access error
            }
        }
    }

    private fun saveRemoteDataAtDatabase(produtolList: List<Produto>) {
        CoroutineScope(Dispatchers.IO).launch {
            for(produto in produtolList) {
                ProdutoDAO.insert(produto)
            }
        }
    }

}
