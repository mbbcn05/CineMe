package com.babacan05.cineme.feature_movie.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "table_title")
data class Titles(
    @PrimaryKey(autoGenerate = false) val searchedText:String,
    val movieList:List<Title>

)

data class Title(
    @PrimaryKey (autoGenerate = false) val id:String,
    val name:String,
    val imageUrl:String
)

@Entity(tableName ="title_favoured_table")
data class FavouredTitle(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val titleId:String,
    val favoured:Boolean=false

)


