package com.babacan05.cineme.feature_movie.data.repository

import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_source.TitleApiDataSource
import com.babacan05.cineme.feature_movie.domain.model.Titles
import com.babacan05.cineme.feature_movie.domain.repository.TitleRepository
import com.babacan05.cineme.feature_movie.domain.util.mapTitleDTOToTitle
import javax.inject.Inject

class TitleRepositoryImpl @Inject constructor(private val titleApiDataSource: TitleApiDataSource):TitleRepository {

    override suspend fun getTitles(search:String): DataResult<Titles> {
        val result = titleApiDataSource.responseTitleRetrofit(search)
println("Çalıştı"+result)
         return when (result) {
            is DataResult.Success -> DataResult.Success((mapTitleDTOToTitle(result.data)))
            is DataResult.Error -> DataResult.Error(result.message)

    }
}
}
