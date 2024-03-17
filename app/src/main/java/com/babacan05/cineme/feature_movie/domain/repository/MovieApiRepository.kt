package com.babacan05.cineme.feature_movie.domain.repository

import com.babacan05.cineme.feature_movie.domain.model.MovieResults


interface MovieApiRepository {
    suspend fun getMovies(search:String): MovieResults
}