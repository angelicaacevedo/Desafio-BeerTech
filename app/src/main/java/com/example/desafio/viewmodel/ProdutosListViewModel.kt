package com.example.desafio.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.desafio.entity.Produto
import com.example.desafio.repository.ProdutosListRepository

class ProdutosListViewModel (private val repository: ProdutosListRepository): ViewModel() {

    val  produtoList: LiveData<List<Produto>>
        get() = repository.produtosList
}