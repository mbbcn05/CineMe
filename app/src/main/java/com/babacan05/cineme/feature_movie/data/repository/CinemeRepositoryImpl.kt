package com.babacan05.cineme.feature_movie.data.repository

import com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source.TitleDetailApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_source.TitleApiDataSource
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.model.Titles
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.domain.util.mapTitleDTOToTitle
import com.babacan05.cineme.feature_movie.domain.util.mapTitleDetailDTOToTitleDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CinemeRepositoryImpl @Inject constructor(private val titleDetailApiDataSource: TitleDetailApiDataSource,
                                               private val titleApiDataSource: TitleApiDataSource): CinemeRepository {
    override suspend fun getTitles(search: String): Flow<DataResult<Titles>> {
        val result = titleApiDataSource.responseTitleRetrofit(search)

        return when (result) {
            is DataResult.Success -> DataResult.Success((mapTitleDTOToTitle(result.data)))
            is DataResult.Error -> DataResult.Error(result.message)

        }
    }

    override suspend fun getTitleDetail(search: String): Flow<DataResult<TitleDetail>> {
        val result = titleDetailApiDataSource.responseTitleDetailRetrofit(search)

        return when (result) {
            is DataResult.Success -> DataResult.Success((mapTitleDetailDTOToTitleDetail(result.data)))
            is DataResult.Error -> DataResult.Error(result.message)

        }
    }

}


}