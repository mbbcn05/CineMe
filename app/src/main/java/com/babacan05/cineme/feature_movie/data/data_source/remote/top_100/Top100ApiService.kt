package com.babacan05.cineme.feature_movie.data.data_source.remote.top_100

import com.babacan05.cineme.feature_movie.data.model.remote.top100.ImdbTop100ListItemDTO
import retrofit2.http.GET

interface Top100ApiService {
    @GET("/")
    suspend fun getTopMovies(): List<ImdbTop100ListItemDTO> // Movie, API'den gelen film verilerini temsil eden bir sınıf olmalıdır
}