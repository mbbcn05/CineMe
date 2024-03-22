package com.babacan05.cineme.feature_movie.domain.util

import com.babacan05.cineme.feature_movie.data.model.remote.top100.ImdbTop100ListItemDTO
import com.babacan05.cineme.feature_movie.domain.model.Title



    fun mapTop100DTOToTitle(top100ListItemDTO: ImdbTop100ListItemDTO): Title {
        return Title(
            id = top100ListItemDTO.imdbid,
            name = top100ListItemDTO.title,
            imageUrl = top100ListItemDTO.image,
            rank = top100ListItemDTO.rating.toDouble(),
            description = top100ListItemDTO.description,
            year = top100ListItemDTO.year
                )





}