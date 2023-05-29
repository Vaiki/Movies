package com.example.movie.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.R
import com.example.movie.databinding.ItemActorBinding
import com.example.movie.domain.models.Actor

class ListActorsAdapter :
    ListAdapter<Actor, ListActorsAdapter.ActorsViewHolder>(ActorsItemDiffCallback()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActorsViewHolder {
        val binding = ItemActorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActorsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        val actor = getItem(position)
        holder.bind(actor)
    }

    class ActorsViewHolder(private val binding: ItemActorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: Actor) {
            with(binding) {
                tvName.text = actor.fullName
                Glide.with(itemView.context)
                    .load(actor.photo)
                    .centerCrop()
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.not_found)
                    .into(ivPhoto)
            }
        }
    }
}