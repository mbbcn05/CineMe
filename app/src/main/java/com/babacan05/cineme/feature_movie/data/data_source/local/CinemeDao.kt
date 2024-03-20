package com.babacan05.cineme.feature_movie.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.model.Titles
import kotlinx.coroutines.flow.Flow
@Dao
interface CinemeDao {

    @Query("SELECT * FROM titledetail WHERE favoured=1")
    fun getFavouredTitles(): Flow<List<TitleDetail>>

    @Query("SELECT * FROM tıtles WHERE searchedText =:search")
    suspend fun getTitlesBySearch(search: String)

     @Query("SELECT * FROM titledetail WHERE id=:id")
      suspend fun getTitleDetailById(id:String)

      @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTitleDetail(titleDetail: TitleDetail)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTitles(titles: Titles)

    @Update
    suspend fun updateFavouredTitle(titleDetail: TitleDetail)

}
