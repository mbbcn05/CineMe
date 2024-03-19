package com.babacan05.cineme.feature_movie.domain.repository

import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.domain.model.Titles


interface TitleRepository {
    suspend fun getTitles(search:String): DataResult<Titles>
}