package com.babacan05.cineme.feature_movie.data.data_source.remote.movie_detail

import com.babacan05.cineme.feature_movie.data.model.remote.movie_detail.MoviesDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieApiService{
    @Headers(
        "X-RapidAPI-Key: df0e0b9ff7msh5e0b3c6e26ff767p1b6b6bjsn264a19ea3f64",
        "X-RapidAPI-Host: imdb8.p.rapidapi.com"
    )
    @GET("/auto-complete")
    suspend  fun autoComplete(@Query("q") query: String): MoviesDTO
}
