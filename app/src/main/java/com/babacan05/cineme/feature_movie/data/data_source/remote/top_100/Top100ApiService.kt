package com.babacan05.cineme.feature_movie.data.data_source.remote.top_100

import com.babacan05.cineme.feature_movie.data.model.remote.top100.ImdbTop100ListItemDTO
import retrofit2.http.GET
import retrofit2.http.Header

interface Top100ApiService {
    @GET("/")
    suspend fun getTopMovies(
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") apiHost: String
    ): List<ImdbTop100ListItemDTO>
}