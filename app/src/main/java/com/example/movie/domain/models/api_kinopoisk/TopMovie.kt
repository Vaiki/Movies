package com.example.movie.domain.models.api_kinopoisk

data class TopMovie(
    val films: List<Film>,
    val pagesCount: Int
)