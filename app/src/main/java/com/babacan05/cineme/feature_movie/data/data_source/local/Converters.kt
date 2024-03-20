package com.babacan05.cineme.feature_movie.data.data_source.local

import androidx.room.TypeConverter
import com.babacan05.cineme.feature_movie.domain.model.Actor
import com.babacan05.cineme.feature_movie.domain.model.MoreLikeTitle
import com.babacan05.cineme.feature_movie.domain.model.Title
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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