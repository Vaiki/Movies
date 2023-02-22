package com.example.movie.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movie.domain.models.Film
import com.example.movie.R
import com.example.movie.databinding.ItemMovieBinding

class ListFilmAdapter :
    ListAdapter<Film, ListFilmAdapter.FilmViewHolder>(MovieItemDiffCallback()) {

    var onItemFilmClickListener:((Film)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val movieItem = getItem(position)
        holder.bind(movieItem)
        holder.itemView.setOnClickListener {
            onItemFilmClickListener?.invoke(movieItem)
        }

    }

    class FilmViewHolder(private val binding: ItemMovieBinding) : ViewHolder(binding.root) {
        fun bind(film: Film) {
            with(binding) {
                tvTitle.text = film.title
                tvDescription.text = film.description
                tvAdult.text = film.adult
                ratingBar.rating = film.rating.toFloat()
                Glide.with(itemView.context)
                    .load(film.poster)
                    .centerCrop()
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.not_found)
                    .into(ivPoster)
            }
        }
    }
}

