package com.example.movie.domain.models.api_models.details

data class Genre(
    val id: Int,
    val name: String,
    var isChecked:Boolean = false
)