package com.example.movie.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.movie.domain.models.Actor

class ActorsItemDiffCallback : DiffUtil.ItemCallback<Actor>() {
    override fun areItemsTheSame(oldItem: Actor, newItem: Actor): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Actor, newItem: Actor): Boolean {
        return oldItem == newItem
    }
}