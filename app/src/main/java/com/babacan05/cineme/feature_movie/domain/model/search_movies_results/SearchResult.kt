package com.babacan05.cineme.feature_movie.domain.model.search_movies_results

data class SearchResult(
    val d: List<Content>,
    val q: String,
    val v: Int
) {
    constructor() : this(emptyList(), "", 0)
}