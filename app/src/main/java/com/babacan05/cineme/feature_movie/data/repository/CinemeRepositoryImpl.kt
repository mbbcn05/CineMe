package com.babacan05.cineme.feature_movie.data.repository

import com.babacan05.cineme.feature_movie.data.data_source.local.CinemeDao
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source.TitleDetailApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_source.TitleApiDataSource
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.model.Titles
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CinemeRepositoryImpl @Inject constructor(
    private val titleDetailApiDataSource: TitleDetailApiDataSource,
    private val titleApiDataSource: TitleApiDataSource,
    private val cinemeDao: CinemeDao
): CinemeRepository {

    override suspend fun getTitles(search: String): Flow<DataResult<Titles>> {
        val daoResult=cinemeDao.getTitlesBySearch(search)
        if(daoResult==null){
            println("veri remotede geldi titles")

            return titleApiDataSource.responseTitleRetrofit(search).map { result ->
                when (result) {
                    is DataResult.Success -> {
                        cinemeDao.insertTitles(result.data)
                        DataResult.Success(result.data)
                    }
                    is DataResult.Error -> {
                        result
                    }
                }
            }


        }else{
            return flow {
                emit(DataResult.Success(daoResult))
                println("veri localden geldi")
            }
        }

    }

    override suspend fun getTitleDetail(id: String): Flow<DataResult<TitleDetail>> {

        val daoResult=cinemeDao.getTitleDetailById(id)
        if(daoResult==null){
            println("veri remotede geldi")
        return titleDetailApiDataSource.responseTitleDetailRetrofit(id).map { result ->
            when (result) {
                is DataResult.Success -> {
                    cinemeDao.insertTitleDetail(result.data)
                    DataResult.Success(result.data)
                }
                is DataResult.Error -> {

                    result
                }
            }
        }
    }else {
            return flow {
                emit(DataResult.Success(daoResult))
                println(daoResult.videoUrl)
                println("veri localden geldi")
            }

        }
        }
}
