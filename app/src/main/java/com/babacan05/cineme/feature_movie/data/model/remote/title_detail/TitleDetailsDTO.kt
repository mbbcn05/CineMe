package com.babacan05.cineme.feature_movie.data.model.remote.title_detail

data class TitleDetailsDTO(
    val cast: Cast,// kalsın
    val directors: List<Director>,//kalsın
    val featuredReviews: FeaturedReviews,//kalsın
    val genres: Genres,//kalsın
    val id: String,
    val moreLikeThisTitles: MoreLikeThisTitles,//kalsın kullanırsın
    val plot: Plot,//kalsın
    val primaryImage: PrimaryImageXX,
    val primaryVideos: PrimaryVideos,//kalsın note içindeki description da kalacak
    val ratingsSummary: RatingsSummaryX,
    val releaseYear: ReleaseYearXXX,//kalsın
    val titleGenres: TitleGenresX,// buradan genreler türlerin bilgisi alınacak
    val titleText: TitleTextXXXX,

)