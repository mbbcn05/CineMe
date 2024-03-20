package com.babacan05.cineme.feature_movie.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.babacan05.cineme.feature_movie.domain.model.Actor
import com.babacan05.cineme.feature_movie.domain.model.MoreLikeTitle
import com.babacan05.cineme.feature_movie.domain.model.Title
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.model.Titles
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Database(
    entities = [Titles::class,TitleDetail::class],
    version = 1
)
@TypeConverters(TitleListConverter::class,ActorListConverter::class,
    MoreLikeTitleListConverter::class,
    GenreListConverter::class)
abstract class CinemeDataBase: RoomDatabase() {

    abstract val cinemeDao: CinemeDao

    companion object {
        const val DATABASE_NAME = "cineme_db"
    }
}
class ActorListConverter {
    @TypeConverter
    fun fromString(value: String): List<Actor> {
        val listType = object : TypeToken<List<Actor>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Actor>): String {
        return Gson().toJson(list)
    }
}

class MoreLikeTitleListConverter {
    @TypeConverter
    fun fromString(value: String): List<MoreLikeTitle> {
        val listType = object : TypeToken<List<MoreLikeTitle>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<MoreLikeTitle>): String {
        return Gson().toJson(list)
    }
}
class TitleListConverter {
    @TypeConverter
    fun fromTitleList(titleList: List<Title>?): String? {
        return titleList?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun toTitleList(titleListString: String?): List<Title>? {
        return titleListString?.let { Gson().fromJson(it, object : TypeToken<List<Title>>() {}.type) }
    }
}
class GenreListConverter {
    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return Gson().toJson(list)
    }
}