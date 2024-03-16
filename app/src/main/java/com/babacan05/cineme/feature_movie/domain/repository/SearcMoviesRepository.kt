package com.babacan05.cineme.feature_movie.domain.repository

import com.babacan05.cineme.feature_movie.domain.model.search_movies_results.SearchResult
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchMoviesRepository {
    @Headers(
        "X-RapidAPI-Key: df0e0b9ff7msh5e0b3c6e26ff767p1b6b6bjsn264a19ea3f64",
        "X-RapidAPI-Host: imdb8.p.rapidapi.com"
    )
    @GET("/auto-complete")
    suspend  fun autoComplete(@Query("q") query: String): SearchResult
}
