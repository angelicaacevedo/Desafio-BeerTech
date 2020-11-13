package com.example.desafio.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafio.repository.ProdutosListRepository

class ProdutosListViewModelFactory (private val repository: ProdutosListRepository):  ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProdutosListViewModel::class.java)) {
            return ProdutosListViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}