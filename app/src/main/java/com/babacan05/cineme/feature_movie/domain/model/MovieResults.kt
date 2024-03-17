package com.babacan05.cineme.feature_movie.domain.model

data class MovieResults(
    val searchedText:String,
    val movieList:List<Movie>

)

data class Movie(
    val id:String,
    val name:String,
    val imageUrl:String
)