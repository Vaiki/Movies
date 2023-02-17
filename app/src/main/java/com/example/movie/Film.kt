package com.example.movie

import android.icu.text.CaseMap.Title

data class Film(
    val id: Int,
    val title: String,
    val description: String,
    val poster: String,
    val rating: Double,
    val adult: String
) {

}
