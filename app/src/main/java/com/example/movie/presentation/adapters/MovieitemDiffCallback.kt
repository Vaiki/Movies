package com.example.movie.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.movie.domain.models.Film

class MovieItemDiffCallback : DiffUtil.ItemCallback<Film>() {
    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem == newItem
    }
}