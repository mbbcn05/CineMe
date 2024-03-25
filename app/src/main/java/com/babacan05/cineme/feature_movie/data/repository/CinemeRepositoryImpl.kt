package com.babacan05.cineme.feature_movie.data.repository

import com.babacan05.cineme.feature_movie.data.data_source.local.CinemeDao
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source.TitleDetailApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_source.TitleApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.top_100.Top100ApiDataSource
import com.babacan05.cineme.feature_movie.domain.model.FavouredTitle
import com.babacan05.cineme.feature_movie.domain.model.Title
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.model.Titles
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.domain.util.mapTop100DTOToTitle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CinemeRepositoryImpl @Inject constructor(
    private val titleDetailApiDataSource: TitleDetailApiDataSource,
    private val titleApiDataSource: TitleApiDataSource,
    private val top100ApiDataSource: Top100ApiDataSource,
    private val cinemeDao: CinemeDao
): CinemeRepository {

    override suspend fun getTitles(search: String): Flow<DataResult<Titles>> {
        val daoResult=cinemeDao.getTitlesBySearch(search)
        if(daoResult==null){

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
            }
        }

    }

    override suspend fun getTitleDetail(id: String): Flow<DataResult<TitleDetail>> {
        val daoResult=cinemeDao.getTitleDetailById(id)
        if(daoResult==null){
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
            println(daoResult.videoUrl)

            return flow {
                emit(DataResult.Success(daoResult))
            }

        }
        }


    override suspend fun getTop100Title():Flow<List<Title>>{
        return cinemeDao.getTop100Title().map { dataResult ->
            if (dataResult.isNullOrEmpty()) {
                val apiResult = top100ApiDataSource.top100ApiRetrofit().map { mapTop100DTOToTitle(it) }
                apiResult.forEach { cinemeDao.insertTop100Title(it) }
                apiResult
            } else {
                dataResult
            }
        }
    }



    override suspend fun getFavouredTitleIdList():Flow<List<String>> =cinemeDao.getFavouredTitleIds()
    override suspend fun updateFavouredTitleID(favouredTitle: FavouredTitle){
        cinemeDao.updateFavouredTitle(favouredTitle)
    }
}
