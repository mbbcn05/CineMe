package com.babacan05.cineme.feature_movie.domain.repository

import com.babacan05.cineme.feature_movie.domain.model.TitleDetail

interface TitleDetailRepository {
    suspend fun getVideos(): List<TitleDetail>

}