package com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source

import com.babacan05.cineme.feature_movie.data.model.remote.title_detail.TitleDetailDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TitleDetailApiService {

    @Headers(
        "X-RapidAPI-Key:**********",
        "X-RapidAPI-Host: imdb146.p.rapidapi.com"
    )
    @GET("/v1/title")
  suspend  fun getTitleDetails(@Query("id") imdbId: String):TitleDetailDTO
}

