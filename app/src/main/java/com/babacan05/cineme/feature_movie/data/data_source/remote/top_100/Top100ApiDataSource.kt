package com.babacan05.cineme.feature_movie.data.data_source.remote.top_100

import javax.inject.Inject

class Top100ApiDataSource @Inject constructor(val service: Top100ApiService){


    suspend fun top100ApiRetrofit()= service.getTopMovies("df0e0b9ff7msh5e0b3c6e26ff767p1b6b6bjsn264a19ea3f64",
        "imdb-top-100-movies.p.rapidapi.com")


}