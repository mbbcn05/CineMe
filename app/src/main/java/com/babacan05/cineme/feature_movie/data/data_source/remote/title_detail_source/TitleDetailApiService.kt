package com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source

import com.babacan05.cineme.feature_movie.data.model.remote.title_detail.TitleDetailDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TitleDetailApiService {

    @Headers(
        "X-RapidAPI-Key: df0e0b9ff7msh5e0b3c6e26ff767p1b6b6bjsn264a19ea3f64",
        "X-RapidAPI-Host: imdb146.p.rapidapi.com"
    )
    @GET("/v1/title")
  suspend  fun getTitleDetails(@Query("id") imdbId: String):TitleDetailDTO
}

