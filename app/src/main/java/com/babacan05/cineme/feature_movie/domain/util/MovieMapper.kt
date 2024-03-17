package com.babacan05.cineme.feature_movie.domain.util

import com.babacan05.cineme.feature_movie.data.model.remote.movie_detail.MoviesDTO
import com.babacan05.cineme.feature_movie.domain.model.Movie
import com.babacan05.cineme.feature_movie.domain.model.MovieResults

object MovieMapper {
    fun mapMoviesDTOToMovieResults(moviesDTO: MoviesDTO): MovieResults {
        return MovieResults(
            searchedText = moviesDTO.q,
            movieList=moviesDTO.d.map {
                Movie(
                    id = it.id,
                    name = it.l,
                    imageUrl = it.i.imageUrl
                )
            }


        )
    }
}