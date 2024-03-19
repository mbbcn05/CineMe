package com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source


import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.data.model.remote.title_detail.TitleDetailDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TitleDetailApiDataSource@Inject constructor(val service: TitleDetailApiService) {
    suspend fun responseTitleDetailRetrofit(search: String): Flow<DataResult<TitleDetailDTO>> = flow{


        try {
            val response = service.getTitleDetails(search)
            emit(DataResult.Success(response))


        } catch (e: Exception) {
            emit(DataResult.Error(e.message ?: "Unknown error"))

        }

    }
    }
