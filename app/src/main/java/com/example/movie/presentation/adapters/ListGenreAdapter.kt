package com.example.movie.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.movie.databinding.ItemChipsBinding
import com.example.movie.domain.models.api_models.details.Genre

class ListGenreAdapter() :
    RecyclerView.Adapter<ListGenreAdapter.GenreViewHolder>() {

    var onItemGenreClickListener: ((Genre) -> Unit)? = null

    private val differCallBack = object : DiffUtil.ItemCallback<Genre>() {
        override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val binding = ItemChipsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreViewHolder(binding)
    }

    override fun getItemCount(): Int = differ.currentList.size
    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val itemGenre = differ.currentList[position]
        Log.d("ADAPTER", itemGenre.toString())
        holder.bind(itemGenre)
        holder.binging.chipAction.setOnClickListener { onItemGenreClickListener?.invoke(itemGenre) }
    }

    inner class GenreViewHolder(val binging: ItemChipsBinding) : ViewHolder(binging.root) {
        fun bind(genre: Genre) {
            binging.chipAction.text = genre.name
            binging.chipAction.isChecked = genre.isChecked
        }
    }
}