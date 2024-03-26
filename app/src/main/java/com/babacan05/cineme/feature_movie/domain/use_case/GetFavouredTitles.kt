package com.babacan05.cineme.feature_movie.domain.use_case

import com.babacan05.cineme.feature_movie.domain.model.Title
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository
import kotlinx.coroutines.flow.Flow

class GetFavouredTitles(private val cinemeRepository: CinemeRepository) {

    suspend  operator fun invoke(
): Flow<List<Title>> {
    return cinemeRepository.getFavouredTitles()
}
}

