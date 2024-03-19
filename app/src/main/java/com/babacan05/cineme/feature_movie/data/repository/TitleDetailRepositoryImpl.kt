package com.babacan05.cineme.feature_movie.data.repository

import com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source.TitleDetailApiDataSource
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.repository.TitleDetailRepository
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.domain.util.mapTitleDetailDTOToTitleDetail
import javax.inject.Inject

class TitleDetailRepositoryImpl @Inject constructor(private val titleDetailApiDataSource: TitleDetailApiDataSource):TitleDetailRepository{

   override  suspend fun getTitleDetail(search:String): DataResult<TitleDetail> {
        val result = titleDetailApiDataSource.responseTitleDetailRetrofit(search)

        return when (result) {
            is DataResult.Success -> DataResult.Success((mapTitleDetailDTOToTitleDetail(result.data)))
            is DataResult.Error -> DataResult.Error(result.message)

        }
    }


}
