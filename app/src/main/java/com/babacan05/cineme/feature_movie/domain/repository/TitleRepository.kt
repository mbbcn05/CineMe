package com.babacan05.cineme.feature_movie.domain.repository

import com.babacan05.cineme.feature_movie.domain.model.Title


interface TitleRepository {
    suspend fun getMovies(search:String): Title
}