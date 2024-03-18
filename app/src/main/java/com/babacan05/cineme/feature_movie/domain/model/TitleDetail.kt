package com.babacan05.cineme.feature_movie.domain.model

data class TitleDetail(
    val id:String,
    val name:String,
    val cast:List<String>,
    val imageUrl:String,
    val videoUrl:String,
    val rating:String,
    val releaseYear:String,
    val description:String,//primaryvideos içinde
    val preview:String,



)
