package com.babacan05.cineme.feature_movie.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TitleDetail(
    @PrimaryKey val id:String,
    val name:String,
    val cast:List<Actor>,
    val imageUrl:String,
    val videoUrl:String,
    val rating: Double,
    val releaseYear: Int,
    val plot:String,
    val review:String,
    val genres:List<String>,
    val moreTitles:List<MoreLikeTitle>,
    val director:String,
    val favoured:Boolean=false
    )
@Entity
data class Actor(
   // val id:String, ilerde aktore basınca özelliği getirilebilir
    val name:String,
    val imageUrl:String,
    val character:String,


)
@Entity
data class MoreLikeTitle(
    val id: String,
    val name: String,
    val imageUrl: String,
    val ratingsSummary: Double,
)