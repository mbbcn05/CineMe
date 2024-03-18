package com.babacan05.cineme.feature_movie.data.data_source.remote.title_source

import com.babacan05.cineme.feature_movie.data.model.remote.title.TitleDTO
import javax.inject.Inject

class TitleApiDataSource @Inject constructor(val service: TitleApiService){

    suspend fun responseRetrofit (search: String):TitleDTO  {



        try {
            val response= service.autoComplete(search)
            return response


        }catch (e:Exception){
            return TitleDTO()

        }

    }

}
