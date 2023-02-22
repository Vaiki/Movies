package com.example.movie.domain

import com.example.movie.domain.models.api_models.details.Genre

class GetFilteredListUseCase(private val repository: Repository) {

    fun editGenreList(genre: Genre) {
        repository.editGenreList(genre)
    }

}