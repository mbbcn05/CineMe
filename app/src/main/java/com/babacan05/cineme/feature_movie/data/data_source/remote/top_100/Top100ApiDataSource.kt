package com.babacan05.cineme.feature_movie.data.data_source.remote.top_100

import javax.inject.Inject

class Top100ApiDataSource @Inject constructor(val service: Top100ApiService){


    suspend fun top100ApiRetrofit()= service.getTopMovies("*******",
        "imdb-top-100-movies.p.rapidapi.com")


}
