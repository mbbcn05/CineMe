package com.babacan05.cineme.feature_movie.presentation.cineme_main

import com.babacan05.cineme.feature_movie.domain.model.Title

data class TitlesState(
    val listSearchedTitles: List<Title> =  emptyList(),
    val listFavouredTitles: List<Title> = emptyList(),
    val listTop100Titles: List<Title> =  emptyList(),
)