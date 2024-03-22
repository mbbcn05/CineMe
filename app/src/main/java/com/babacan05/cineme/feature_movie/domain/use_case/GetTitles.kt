package com.babacan05.cineme.feature_movie.domain.use_case

import com.babacan05.cineme.feature_movie.domain.model.Titles
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTitles (
    private val cinemeRepository:CinemeRepository
    ) {

      suspend  operator fun invoke(search:String
        ): Flow<DataResult<Titles>> {

          if(search.isEmpty()){
              return flow {
                  DataResult.Error("Emty List")
              }

          }else{
            return cinemeRepository.getTitles(search)
        }
      }
    }
