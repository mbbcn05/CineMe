package com.babacan05.cineme.feature_movie.domain.use_case

import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTitleDetail (private val cinemeRepository: CinemeRepository){

    suspend  operator fun invoke(search:String
    ): Flow<DataResult<TitleDetail>> {

        return cinemeRepository.getTitleDetail(search)


    }
}