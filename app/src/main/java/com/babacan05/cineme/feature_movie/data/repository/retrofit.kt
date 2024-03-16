package com.babacan05.cineme.feature_movie.data.repository

import com.babacan05.cineme.feature_movie.domain.repository.SearchMoviesRepository
import javax.inject.Inject


class SearchMoviesImpl @Inject constructor(val service: SearchMoviesRepository){

    suspend fun responseRetrofit (){



        try {
            val response= service.autoComplete("game of thr")



            println("HEEEY"+"ID: ${response.d[0].i.imageUrl}")

        }catch (e:Exception){
            println(e.message)

        }

    }



}









