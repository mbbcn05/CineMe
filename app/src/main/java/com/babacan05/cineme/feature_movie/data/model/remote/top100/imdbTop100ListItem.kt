package com.babacan05.cineme.feature_movie.data.model.remote.top100

data class ImdbTop100ListItemDTO(
    val big_image: String,
    val description: String,
    val image: String,
    val imdbid: String,
    val rating: String,
    val title: String,
    val year: Int
)