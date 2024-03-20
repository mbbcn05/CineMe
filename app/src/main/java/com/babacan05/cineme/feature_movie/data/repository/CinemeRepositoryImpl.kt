package com.babacan05.cineme.feature_movie.data.repository

import com.babacan05.cineme.feature_movie.data.data_source.local.CinemeDao
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source.TitleDetailApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_source.TitleApiDataSource
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.model.Titles
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CinemeRepositoryImpl @Inject constructor(
    private val titleDetailApiDataSource: TitleDetailApiDataSource,
    private val titleApiDataSource: TitleApiDataSource,
    cinemeDao: CinemeDao
): CinemeRepository {
    override suspend fun getTitles(search: String): Flow<DataResult<Titles>> {
        return     titleApiDataSource.responseTitleRetrofit(search)


    }


    override suspend fun getTitleDetail(search: String): Flow<DataResult<TitleDetail>> {

        return         titleDetailApiDataSource.responseTitleDetailRetrofit(search)


    }
    }
