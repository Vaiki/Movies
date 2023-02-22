package com.example.movie.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movie.domain.models.Film
import com.example.movie.domain.Repository
import com.example.movie.domain.models.api_models.details.Genre
import okhttp3.internal.filterList

object RepositoryImpl : Repository {

    private val filmListLD = MutableLiveData<List<Film>>()
    private val filmList = mutableListOf<Film>(
        Film(
            1,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            4.5,
            "16+",
            12
        ),
        Film(
            2,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            8.6,
            "16+", 28
        ),
        Film(
            3,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            8.6,
            "16+",
            16
        ),
        Film(
            4,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            8.6,
            "16+",
            35
        ), Film(
            5,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            8.6,
            "16+",
            36
        ), Film(
            6,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            8.6,
            "16+", 12

        ),
        Film(
            7,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            8.6,
            "16+"
        ),
        Film(
            8,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            8.6,
            "16+"
        ),
        Film(
            9,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            8.6,
            "16+"
        ), Film(
            10,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            8.6,
            "16+"
        ),
        Film(
            11,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            8.6,
            "16+"
        ),
        Film(
            12,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи",
            "https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg",
            8.6,
            "16+"
        )
    )
    private val genreListLD = MutableLiveData<List<Genre>>()
    private val genreList = mutableListOf<Genre>(
        Genre(28, "боевик"),
        Genre(12, "приключения"),
        Genre(16, "мультфильм"),
        Genre(35, "комедия"),
        Genre(80, "криминал"),
        Genre(99, "документальный"),
        Genre(18, "драма"),
        Genre(10751, "семейный"),
        Genre(14, "фэнтези")
    )

    override fun getFilmList(): LiveData<List<Film>> {
        updateFilmList()
        return filmListLD
    }

    override fun getGenreList(): LiveData<List<Genre>> {
        updateGenreList()
        return genreListLD
    }

    override fun editGenreList(genre: Genre) {
        genreList.find { it.id == genre.id }?.isChecked = genre.isChecked
        updateGenreList()
    }

    override fun getFilmItem(id: Int): Film {
        return filmList.first { it.id == id }
    }

    private fun updateFilmList() {
        filmListLD.value = filmList.toList()
    }

    private fun updateGenreList() {
        genreListLD.value = genreList.toList()
    }

    override fun getFilteredFilmList() {

        val genreIsChecked = genreList.filter { it.isChecked }.map { it.id }
        val filteredList = filmList.filter {
            genreIsChecked.contains(it.genre)
        }
        if (filteredList.isNotEmpty()) {
            filmListLD.value = filteredList.toList()
        } else updateFilmList()
    }

}


