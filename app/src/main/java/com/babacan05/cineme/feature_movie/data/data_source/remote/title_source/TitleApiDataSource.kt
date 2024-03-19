package com.babacan05.cineme.feature_movie.data.data_source.remote.title_source

import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.data.model.remote.title.TitleDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TitleApiDataSource @Inject constructor(val service: TitleApiService){

    suspend fun responseTitleRetrofit (search: String): Flow<DataResult<TitleDTO>> = flow{



        try {
            val response= service.autoComplete(search)
            emit(DataResult.Success(response))


        }catch (e:Exception){
            emit(DataResult.Error(e.message ?: "Unknown error"))

        }

    }

}
