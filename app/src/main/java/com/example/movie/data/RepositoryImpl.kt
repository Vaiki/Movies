package com.example.movie.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movie.domain.Repository
import com.example.movie.domain.models.Actor
import com.example.movie.domain.models.Film
import com.example.movie.domain.models.api_models.details.Genre


object RepositoryImpl : Repository {

    private val filmListLD = MutableLiveData<List<Film>>()
    private val filmList = mutableListOf<Film>(
        Film(
            1,
            "Жизнь Пи",
            "Это история сына владельца одного индийского зоопарка, мальчика по имени Пи. Он познаёт мир, учится отстаивать свои принципы, ищет собственную дорогу к Богу, живя по канонам трёх конфессий, влюбляется… Но волей судьбы его семья вынуждена эмигрировать. На полпути между Индией и Канадой корабль терпит крушение, и Пи остаётся в шлюпке вместе с бенгальским тигром, гиеной, зеброй и орангутаном. Вокруг безбрежная водная гладь, а впереди — неизвестность...",
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


    private val actorListLD = MutableLiveData<List<Actor>>()
    private val actorsList = mutableListOf<Actor>(

        Actor(
            12,
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1777765/d8f7a6be-7955-45e9-af04-997ca3bf1494/orig",
            "Ирфан Хан"
        ),
        Actor(
            12,
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/2b601945-8ca9-4f87-9fb8-9086a4a33427/orig",
            "Ирфан Хан"
        ),
        Actor(
            23,
            "data:image/jpeg;base64,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",
            "Жерар Депардьё"
        ),
        Actor(
            24,
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/6b500eed-30b5-46f0-9d71-6e5971ecc2cb/orig",
            "Рейф Спол"
        )
    )

    override fun getFilmList(): LiveData<List<Film>> {
        updateFilmList()
        return filmListLD
    }

    fun getActorList(): LiveData<List<Actor>> {
        actorListLD.value = actorsList
        return actorListLD
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


