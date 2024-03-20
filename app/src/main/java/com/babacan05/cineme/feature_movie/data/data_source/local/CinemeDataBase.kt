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
