package com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source

import retrofit2.http.GET

interface TitleDetailApiService {
    @GET("title/details")
    suspend fun getMovieDetails(
        @Query("tconst") tconst: String
    ): Response<MovieDetails>
}