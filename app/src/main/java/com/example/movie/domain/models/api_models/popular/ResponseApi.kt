package com.example.movie.domain.models.api_models.popular

data class ResponseApi(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)