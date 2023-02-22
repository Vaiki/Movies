package com.example.movie.domain.models

import com.example.movie.domain.models.api_models.details.Genre

data class Film(
    val id: Int,
    val title: String,
    val description: String,
    val poster: String,
    val rating: Double,
    val adult: String,
    val genre: Int = 28
) {

}
