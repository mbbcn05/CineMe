package com.babacan05.cineme.feature_movie.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_title")
data class Titles(
    @PrimaryKey(autoGenerate = false) val searchedText:String,
    val movieList:List<Title>

)
@Entity(tableName = "title")
data class Title(
    @PrimaryKey (autoGenerate = false) val id:String,
    val name:String,
    val imageUrl:String,
    val rank: Double =0.0,
    val description:String="",
   val year:Int=0,
    val isTop100:Boolean=false
)

@Entity(tableName ="title_favoured_table")
data class FavouredTitle(
    @PrimaryKey(autoGenerate = false) val titleId:String="",
    val favoured:Boolean=false

)
