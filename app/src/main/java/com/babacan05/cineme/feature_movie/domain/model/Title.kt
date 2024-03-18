package com.babacan05.cineme.feature_movie.domain.model


data class Titles(
    val searchedText:String,
    val movieList:List<Title>

)

data class Title(
    val id:String,
    val name:String,
    val imageUrl:String
)