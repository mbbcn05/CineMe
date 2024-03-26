package com.babacan05.cineme.feature_movie.data.model.remote.title_detail

data class TitleDetailDTO(
    val cast: Cast?,
    val directors: List<Director>,
    val featuredReviews: FeaturedReviews,
    val genres: Genres,
    val id: String,
    val moreLikeThisTitles: MoreLikeThisTitles,
    val plot: Plot,
    val primaryImage: PrimaryImageXX,
    val primaryVideos: PrimaryVideos,
    val ratingsSummary: RatingsSummaryX,
    val releaseYear: ReleaseYearXXX,
    val titleText: TitleTextXXXX,

) {

}