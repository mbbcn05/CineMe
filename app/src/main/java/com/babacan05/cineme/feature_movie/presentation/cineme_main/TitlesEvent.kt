package com.babacan05.cineme.feature_movie.presentation.cineme_main

sealed class TitlesEvent{
    data class RemoveFavoured(val titleId:String): TitlesEvent()

    data class AddFavoured(val titleId:String): TitlesEvent()



}