package com.babacan05.cineme.feature_movie.data.data_source.remote.movie_detail

import com.babacan05.cineme.feature_movie.data.model.remote.movie_detail.Content
import com.babacan05.cineme.feature_movie.data.model.remote.movie_detail.MoviesDTO
import javax.inject.Inject

class MovieApiDataSource @Inject constructor(val service: MovieApiService){

    suspend fun responseRetrofit (search: String):MoviesDTO  {



        try {
            val response= service.autoComplete(search)
            return response


        }catch (e:Exception){
            return MoviesDTO()

        }

    }

}
