package com.babacan05.cineme.di

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
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModuleMovie {

    @Provides
    @Singleton
    fun provideOkHttpClient() =OkHttpClient.Builder()
        .readTimeout(6, TimeUnit.SECONDS)
        .writeTimeout(6, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideMovieApiService(okHttpClient: OkHttpClient): TitleApiService = Retrofit.Builder()
        .baseUrl("https://imdb8.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build().create(TitleApiService::class.java)

    @Provides
    @Singleton
    fun provideMovieApiDataSource(service: TitleApiService): TitleApiDataSource {
        return TitleApiDataSource(service)
    }


}

@Module
@InstallIn(SingletonComponent::class)
class NetworkModuleVideo {

    @Provides
    @Singleton
    fun provideOkHttpClient() =OkHttpClient.Builder()
        .readTimeout(6, TimeUnit.SECONDS)
        .writeTimeout(6, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideVideoApiService(okHttpClient: OkHttpClient): TitleDetailApiService = Retrofit.Builder()
        .baseUrl("https://imdb-com.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", "df0e0b9ff7msh5e0b3c6e26ff767p1b6b6bjsn264a19ea3f64")
                    .addHeader("X-RapidAPI-Host", "imdb-com.p.rapidapi.com")
                    .build()
                chain.proceed(newRequest)
            }
            .build()//glavier


    @Provides
    @Singleton
    fun provideVideoApiDataSource(service: TitleApiService): TitleApiDataSource {
        return TitleApiDataSource(service)
    }


}
