package com.babacan05.cineme.feature_movie.data.model.remote.title_detail

data class NodeXXXXXXXXXXXXX(
    val id: String,
    val titleText: TitleTextX,


    val primaryImage: PrimaryImageZ,

    val ratingsSummary: RatingSummary,

)
data class TitleTextX(
    val text:String
)
data class RatingSummary(
    val aggregateRating:Double
)
data class PrimaryImageZ(val url:String)