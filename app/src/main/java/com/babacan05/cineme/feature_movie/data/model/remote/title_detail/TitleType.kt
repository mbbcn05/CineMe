package com.babacan05.cineme.feature_movie.data.model.remote.title_detail

data class TitleType(
    val __typename: String,
    val canHaveEpisodes: Boolean,
    val displayableProperty: DisplayableProperty,
    val id: String,
    val text: String
)