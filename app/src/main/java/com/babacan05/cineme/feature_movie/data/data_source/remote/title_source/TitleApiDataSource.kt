package com.babacan05.cineme.feature_movie.data.data_source.remote.title_source

import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.data.model.remote.title.TitleDTO
import javax.inject.Inject

class TitleApiDataSource @Inject constructor(val service: TitleApiService){

    suspend fun responseTitleRetrofit (search: String): DataResult<TitleDTO> {



        try {
            val response= service.autoComplete(search)
            return DataResult.Success(response)


        }catch (e:Exception){
            return DataResult.Error(e.message ?: "Unknown error")

        }

    }

}
