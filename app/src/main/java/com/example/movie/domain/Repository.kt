package com.example.movie.domain

import androidx.lifecycle.LiveData
import com.example.movie.domain.models.Film
import com.example.movie.domain.models.api_models.details.Genre

interface Repository {
   fun getFilteredFilmList()

    fun getFilmList(): LiveData<List<Film>>

    fun getFilmItem(id: Int): Film

    fun getGenreList(): LiveData<List<Genre>>

    fun editGenreList(genre: Genre)


}