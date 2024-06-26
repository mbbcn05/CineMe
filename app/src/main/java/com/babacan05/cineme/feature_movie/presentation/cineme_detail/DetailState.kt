package com.babacan05.cineme.feature_movie.presentation.cineme_detail

import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.util.DataResult

data class DetailState(
    val detailResult:DataResult<TitleDetail> =DataResult.Error("Loading"),
val videoState: VideoState =VideoState(),
    val favouredIdList:List<String> = emptyList(),
val menustate: Menustate=Menustate.ACTORS
)

data class VideoState(val videoUrl:String="", var currentPosition:Long=0)
enum class Menustate{
    ACTORS,
    REVIEW,
    MORELIKES

}