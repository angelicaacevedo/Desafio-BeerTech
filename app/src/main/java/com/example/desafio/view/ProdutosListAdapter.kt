package com.example.desafio.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio.R
import com.example.desafio.entity.Produto

class ProdutosListAdapter: RecyclerView.Adapter<ProdutosListAdapter.ProdutosListViewHolder>() {
    var data = listOf<Produto>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.produto_item, parent, false) as View
        return ProdutosListViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ProdutosListViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item.name, item.thumbUrl)
    }

    inner class ProdutosListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        private val itemTitle = itemView.findViewById<TextView>(R.id.produtoName)
        private val itemImage = itemView.findViewById<ImageView>(R.id.produtoImage)

        fun bind(title: String, url: String) {
            itemTitle.text = title
            val url: String = url

            if(url.isNotEmpty()) {
                Glide.with(itemView.context)
                    .load(url)
                    .placeholder(R.drawable.ic_produto)
                    .error(R.drawable.ic_produto)
                    .into(itemImage)
            } else {
                Glide.with(itemView.context).clear(itemView)
                itemImage.setImageResource(R.drawable.ic_produto)
            }
        }
    }
}