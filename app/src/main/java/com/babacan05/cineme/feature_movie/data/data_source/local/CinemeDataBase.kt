package com.babacan05.cineme.feature_movie.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.model.Titles

@Database(
    entities = [Titles::class,TitleDetail::class],
    version = 1
)
abstract class CinemeDataBase: RoomDatabase() {

    abstract val cinemeDao: CinemeDao

    companion object {
        const val DATABASE_NAME = "cineme_db"
    }
}