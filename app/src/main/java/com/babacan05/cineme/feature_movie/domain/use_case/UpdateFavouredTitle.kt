package com.babacan05.cineme.feature_movie.domain.use_case

import com.babacan05.cineme.feature_movie.domain.model.FavouredTitle
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository

class UpdateFavouredTitle (private val cinemeRepository: CinemeRepository){

    suspend  operator fun invoke(favouredtitle:FavouredTitle
    ) {
        return cinemeRepository.updateFavouredTitleID(favouredtitle)
    }
}