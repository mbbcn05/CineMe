package com.babacan05.cineme.feature_movie.domain.util

import com.babacan05.cineme.feature_movie.data.model.remote.title.TitleDTO
import com.babacan05.cineme.feature_movie.domain.model.Title
import com.babacan05.cineme.feature_movie.domain.model.Titles



    fun mapTitleDTOToTitle(moviesDTO: TitleDTO): Titles {
        return Titles(
            searchedText = moviesDTO.q,
            movieList=moviesDTO.d.map {
                Title(
                    id = it.id,
                    name = it.l,
                    imageUrl = it.i.imageUrl
                )
            }


        )

}