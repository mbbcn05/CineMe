package com.babacan05.cineme.di

import android.app.Application
import androidx.room.Room
import com.babacan05.cineme.feature_movie.data.data_source.local.CinemeDataBase
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source.TitleDetailApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_source.TitleApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_source.TitleApiService
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source.TitleDetailApiService
import com.babacan05.cineme.feature_movie.data.data_source.remote.top_100.Top100ApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.top_100.Top100ApiService
import com.babacan05.cineme.feature_movie.data.repository.CinemeRepositoryImpl
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository
import com.babacan05.cineme.feature_movie.domain.use_case.CinemeUseCases
import com.babacan05.cineme.feature_movie.domain.use_case.GetFavouredTitleIds
import com.babacan05.cineme.feature_movie.domain.use_case.GetTitleDetail
import com.babacan05.cineme.feature_movie.domain.use_case.GetTitles
import com.babacan05.cineme.feature_movie.domain.use_case.GetTop100Title
import com.babacan05.cineme.feature_movie.domain.use_case.UpdateFavouredTitle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CinemeAppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() =OkHttpClient.Builder()
        .readTimeout(6, TimeUnit.SECONDS)
        .writeTimeout(6, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideTitleApiService(okHttpClient: OkHttpClient): TitleApiService = Retrofit.Builder()
        .baseUrl("https://imdb8.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build().create(TitleApiService::class.java)

    @Provides
    @Singleton
    fun provideTitleApiDataSource(service: TitleApiService): TitleApiDataSource {
        return TitleApiDataSource(service)
    }
    @Singleton
    @Provides
    fun provideTitleDetailApiService(okHttpClient: OkHttpClient): TitleDetailApiService = Retrofit.Builder()
        .baseUrl("https://imdb146.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(TitleDetailApiService::class.java)



    @Provides
    @Singleton
    fun provideTitleDetailApiDataSource(service: TitleDetailApiService): TitleDetailApiDataSource {
        return TitleDetailApiDataSource(service)
    }
    @Provides
    @Singleton
    fun provideTop100ApiService(okHttpClient: OkHttpClient):Top100ApiService=Retrofit.Builder()
        .baseUrl("https://imdb-top-100-movies.p.rapidapi.com/")

        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(Top100ApiService::class.java)


    @Provides
    @Singleton
    fun provideTop100ApiDataSource(service: Top100ApiService): Top100ApiDataSource {
        return Top100ApiDataSource(service)
    }


    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): CinemeDataBase {
        return Room.databaseBuilder(
            app,
           CinemeDataBase::class.java,
            CinemeDataBase.DATABASE_NAME
        ).build()
    }





    @Provides
    @Singleton
    fun provideCinemeRepository(titleApiDataSource: TitleApiDataSource,
                                titleDetailApiDataSource: TitleDetailApiDataSource,top100ApiDataSource: Top100ApiDataSource,
                                db: CinemeDataBase): CinemeRepository {
        return CinemeRepositoryImpl(titleDetailApiDataSource,titleApiDataSource,top100ApiDataSource,db.cinemeDao)
    }

    @Provides
    @Singleton
    fun provideCinemeUseCases(repository: CinemeRepository): CinemeUseCases {
        return CinemeUseCases(
           getTitles = GetTitles(repository),
            getTitleDetail = GetTitleDetail(repository),
            updateFavouredTitle = UpdateFavouredTitle(repository),
            getFavouredTitleIds= GetFavouredTitleIds(repository),
            getTop100Title = GetTop100Title(repository)
        )
    }

}


