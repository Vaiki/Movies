package com.example.movie.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movie.domain.models.api_models.details.Genre

class GetGenreListUseCase(private val repository: Repository) {
    fun getGenreList():LiveData<List<Genre>> {
        return repository.getGenreList()
    }
}