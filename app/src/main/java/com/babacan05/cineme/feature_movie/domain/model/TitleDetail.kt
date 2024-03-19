package com.babacan05.cineme.feature_movie.domain.model

data class TitleDetail(
    val id:String,
    val name:String,
    val cast:List<Actor>,
    val imageUrl:String,
    val videoUrl:String,
    val rating: Double,
    val releaseYear: Int,
    val plot:String,
    val review:String,
    val genres:List<String>,
    val moreTitles:List<Title>,
    val director:String,





    )
data class Actor(
   // val id:String, ilerde aktore basınca özelliği getililebilir
    val name:String,
    val imageUrl:String,
    val character:String,


)