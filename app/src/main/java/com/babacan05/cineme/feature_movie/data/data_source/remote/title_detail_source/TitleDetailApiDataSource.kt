package com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source


import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.data.model.remote.title_detail.TitleDetailDTO
import javax.inject.Inject

class TitleDetailApiDataSource@Inject constructor(val service: TitleDetailApiService) {
    suspend fun responseTitleDetailRetrofit(search: String): DataResult<TitleDetailDTO> {


        try {
            val response = service.getTitleDetails(search)
            return DataResult.Success(response)


        } catch (e: Exception) {
            return DataResult.Error(e.message ?: "Unknown error")

        }


    }
}
