package com.example.movie.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie.data.RepositoryImpl
import com.example.movie.domain.GetFilmItemUseCase
import com.example.movie.domain.GetFilmListUseCase
import com.example.movie.domain.GetFilteredListUseCase
import com.example.movie.domain.GetGenreListUseCase
import com.example.movie.domain.models.Film
import com.example.movie.domain.models.api_models.details.Genre

class MainViewModel() : ViewModel() {

    private val repository = RepositoryImpl
    private val getFilmItemUseCase = GetFilmItemUseCase(repository)
    private val getFilmListUseCase = GetFilmListUseCase(repository)
    private val getGenreListUseCase = GetGenreListUseCase(repository)
    private val getFilteredListUseCase = GetFilteredListUseCase(repository)


    val listFilms = getFilmListUseCase.getFilmList()
    private val _filmItem = MutableLiveData<Film>()
    val filmItem: LiveData<Film>
        get() = _filmItem

    fun getFilmItem(id: Int) {
        val item = getFilmItemUseCase.getFilmItem(id)
        _filmItem.value = item
    }

    val listGenre = getGenreListUseCase.getGenreList()

    val listActorsLD = repository.getActorList()


    fun editGenreList(genre: Genre) {
        getFilteredListUseCase.editGenreList(genre)
        getFilmListUseCase.getFilteredFilmList()
    }


}