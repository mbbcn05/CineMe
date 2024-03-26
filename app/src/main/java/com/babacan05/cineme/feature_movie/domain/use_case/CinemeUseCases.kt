package com.babacan05.cineme.feature_movie.domain.use_case

data class CinemeUseCases(
    val getTitles: GetTitles,
   val getTitleDetail:GetTitleDetail,
    val updateFavouredTitle: UpdateFavouredTitle,
    val getFavouredTitleIds: GetFavouredTitleIds,
    val getTop100Title: GetTop100Title,
    val getFavouredTitles: GetFavouredTitles
)
