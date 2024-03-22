package com.babacan05.cineme.feature_movie.domain.use_case

import com.babacan05.cineme.feature_movie.domain.model.Titles
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import kotlinx.coroutines.flow.Flow

class GetTitles (
    private val cinemeRepository:CinemeRepository
    ) {

      suspend  operator fun invoke(search:String
        ): Flow<DataResult<Titles>> {
            return cinemeRepository.getTitles(search)
        }
    }
