package com.babacan05.cineme.feature_movie.data.model.remote.title_detail

data class NodeXXXXXXXXXXXXX(
    val id: String,
    val titleText: TitleTextX,
    val titleType: String,
    val originalTitleText: String,
    val primaryImage: String,
    val releaseYear: String,
    val ratingsSummary: String?,
    val runtime: String?,
    val certificate: String?,
    val canRate: Boolean?,
    val titleGenres: List<String>,
    val canHaveEpisodes: Boolean
)
data class TitleTextX(
    val text:String
)