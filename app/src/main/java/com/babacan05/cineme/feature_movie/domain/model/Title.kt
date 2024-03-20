package com.babacan05.cineme.feature_movie.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Titles(
    @PrimaryKey val searchedText:String,
    val movieList:List<Title>

)
@Entity
data class Title(
    val id:String,
    val name:String,
    val imageUrl:String
)