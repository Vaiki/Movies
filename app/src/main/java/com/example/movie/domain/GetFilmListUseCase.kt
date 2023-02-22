package com.example.movie.domain

import androidx.lifecycle.LiveData
import com.example.movie.domain.models.Film

class GetFilmListUseCase(private val repository: Repository) {
    fun getFilmList(): LiveData<List<Film>> {
        return repository.getFilmList()
    }

    fun getFilteredFilmList() {
        repository.getFilteredFilmList()
    }
}