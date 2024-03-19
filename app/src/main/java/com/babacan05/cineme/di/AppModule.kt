package com.babacan05.cineme.di

import com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source.TitleDetailApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_source.TitleApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_source.TitleApiService
import com.babacan05.cineme.feature_movie.data.data_source.remote.title_detail_source.TitleDetailApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModuleTitle {

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

}


