package com.babacan05.cineme.feature_movie.presentation.cineme_main

sealed class TitlesEvent{
    data class SetFavoured(val titleId:String,val isFavoured:Boolean): TitlesEvent()
    data class SearchTitle(val search:String):TitlesEvent()

}