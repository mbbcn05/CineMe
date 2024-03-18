package com.babacan05.cineme.feature_movie.data.repository
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_source.TitleApiDataSource
import com.babacan05.cineme.feature_movie.domain.model.Title
import com.babacan05.cineme.feature_movie.domain.repository.TitleRepository
import com.babacan05.cineme.feature_movie.domain.util.TitleMapper
import javax.inject.Inject

class TitleRepositoryImpl @Inject constructor(val movieApiDataSource: TitleApiDataSource):TitleRepository {

    override suspend fun getMovies(search:String): Title {


         return  TitleMapper.mapMoviesDTOToTitle( movieApiDataSource.responseRetrofit(search))

    }
}