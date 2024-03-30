package com.babacan05.cineme.feature_movie.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "table_detail")
data class TitleDetail(
    @PrimaryKey (autoGenerate = false)val id:String,
    val name:String,
    val cast:List<Actor>,
    val imageUrl:String,
    val videoUrls:List<String>,
    val rating: Double,
    val releaseYear: Int,
    val plot:String,
    val review:String,
    val genres:List<String>,
    val moreTitles:List<MoreLikeTitle>,
    val director:String,
)

data class Actor(
   // val id:String, ilerde aktore basınca özelliği getirilebilir
    @PrimaryKey  (autoGenerate = false) val name:String,
    val imageUrl:String,
    val character:String,


)

data class MoreLikeTitle(
    @PrimaryKey (autoGenerate = false) val id: String,
    val name: String,
    val imageUrl: String,
    val ratingsSummary: Double,
)