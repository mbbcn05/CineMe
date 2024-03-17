package com.babacan05.cineme.feature_movie.data.model.remote.movie_detail

data class MoviesDTO(
    val d: List<Content>,
    val q: String,
    val v: Int
) {
    constructor() : this(emptyList(), "", 0)
}