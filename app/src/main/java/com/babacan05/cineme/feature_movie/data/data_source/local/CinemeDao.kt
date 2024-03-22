package com.babacan05.cineme.feature_movie.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.babacan05.cineme.feature_movie.domain.model.FavouredTitles
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.model.Titles
import kotlinx.coroutines.flow.Flow
@Dao
interface CinemeDao {

    @Query("SELECT * FROM title_favoured_table WHERE favoured=1")
    fun getFavouredTitleIds(): Flow<List<String>>

    @Query("SELECT * FROM table_title WHERE searchedText =:search")
    suspend fun getTitlesBySearch(search: String):Titles?

     @Query("SELECT * FROM table_detail WHERE id=:id")
      suspend fun getTitleDetailById(id:String):TitleDetail?

      @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTitleDetail(titleDetail: TitleDetail)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTitles(titles: Titles)

    @Upsert
    suspend fun updateFavouredTitle(titles: FavouredTitles)
}
