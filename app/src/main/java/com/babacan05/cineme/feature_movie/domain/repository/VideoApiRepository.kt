package com.babacan05.cineme.feature_movie.domain.repository

import com.babacan05.cineme.feature_movie.domain.model.VideoResult

interface VideoApiRepository {
    suspend fun getVideos(): List<VideoResult>

}