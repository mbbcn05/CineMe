package com.babacan05.cineme.feature_movie.data.repository
import com.babacan05.cineme.feature_movie.data.data_source.remote.movie_detail.MovieApiDataSource
import com.babacan05.cineme.feature_movie.domain.model.MovieResults
import com.babacan05.cineme.feature_movie.domain.repository.MovieApiRepository
import com.babacan05.cineme.feature_movie.domain.util.MovieMapper
import javax.inject.Inject

class MovieApiRepositoryImpl @Inject constructor(val movieApiDataSource: MovieApiDataSource):MovieApiRepository {

    override suspend fun getMovies(search:String):MovieResults {


         return  MovieMapper.mapMoviesDTOToMovieResults( movieApiDataSource.responseRetrofit(search))

    }
}