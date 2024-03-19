package com.babacan05.cineme.feature_movie.domain.repository

import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.model.Titles
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import kotlinx.coroutines.flow.Flow

interface CinemeRepository {
  suspend  fun getTitles(search: String): Flow<DataResult<Titles>>
  suspend  fun getTitleDetail(search:String):Flow<DataResult<TitleDetail>>

}