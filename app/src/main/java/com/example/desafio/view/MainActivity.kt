package com.example.desafio.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio.R
import com.example.desafio.data.ProdutoDataBase
import com.example.desafio.network.ProdutosApi
import com.example.desafio.repository.ProdutosListRepository
import com.example.desafio.viewmodel.ProdutosListViewModel
import com.example.desafio.viewmodel.ProdutosListViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val databaseDao = ProdutoDataBase.getDatabase(this, CoroutineScope(Dispatchers.IO)).ProdutoDAO()
        val remoteService = ProdutosApi.retrofitService
        val repository = ProdutosListRepository(databaseDao, remoteService)

        val viewModelFactory = ProdutosListViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, viewModelFactory).get(ProdutosListViewModel::class.java)
        val list = viewModel.produtoList

        val recyclerView = findViewById<RecyclerView>(R.id.produtosListRecyclerView)
        val adapter = ProdutosListAdapter()
        recyclerView.adapter = adapter

        list.observe(this, Observer {
            adapter.data = it
            recyclerView.visibility = View.VISIBLE
            findViewById<ProgressBar>(R.id.loadingProdutosIndicator).visibility = View.GONE
        })
    }
}
