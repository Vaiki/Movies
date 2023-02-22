package com.example.movie.domain

import com.example.movie.domain.models.Film
import com.example.movie.domain.models.FilmItem

class GetFilmItemUseCase(private val repository: Repository) {

    fun getFilmItem(filmItemId: Int): Film {
        return repository.getFilmItem(filmItemId)
    }
}