package com.babacan05.cineme.feature_movie.data.repository

import com.babacan05.cineme.feature_movie.data.data_source.local.CinemeDao
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source.TitleDetailApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_source.TitleApiDataSource
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.model.Titles
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CinemeRepositoryImpl @Inject constructor(
    private val titleDetailApiDataSource: TitleDetailApiDataSource,
    private val titleApiDataSource: TitleApiDataSource,
   val cinemeDao: CinemeDao
): CinemeRepository {
    override suspend fun getTitles(search: String): Flow<DataResult<Titles>> {
        return titleApiDataSource.responseTitleRetrofit(search).map { result ->
            when (result) {
                is DataResult.Success -> {
                    // Veri başarılı şekilde geldiyse, veritabanına ekle
                    cinemeDao.insertTitles(result.data)
                    // Veriyi başarılı şekilde işlediğimizi belirtmek için geri döndürelim
                    DataResult.Success(result.data)
                }
                is DataResult.Error -> {
                    println("Veri alınamadı:")
                    // Hata olduğunu belirtmek için geri döndürelim
                    result
                }
            }
        }
    }

    override suspend fun getTitleDetail(search: String): Flow<DataResult<TitleDetail>> {
        return titleDetailApiDataSource.responseTitleDetailRetrofit(search).map { result ->
            when (result) {
                is DataResult.Success -> {
                    // Veri başarılı şekilde geldiyse, veritabanına ekle
                    cinemeDao.insertTitleDetail(result.data)
                    // Veriyi başarılı şekilde işlediğimizi belirtmek için geri döndürelim
                    DataResult.Success(result.data)
                }
                is DataResult.Error -> {
                    println("Veri alınamadı: ")
                    // Hata olduğunu belirtmek için geri döndürelim
                    result
                }
            }
        }
    }
    }
