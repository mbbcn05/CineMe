package com.babacan05.cineme.feature_movie.data.data_source.remote.title_source

import com.babacan05.cineme.feature_movie.data.model.remote.title.TitleDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TitleApiService{
    @Headers(
        "X-RapidAPI-Key: *********",
        "X-RapidAPI-Host: imdb8.p.rapidapi.com"
    )
    @GET("/auto-complete")
    suspend  fun autoComplete(@Query("q") query: String): TitleDTO
}
