package com.babacan05.cineme.di

import com.babacan05.cineme.feature_movie.data.data_source.remote.movie_detail.MovieApiDataSource
import com.babacan05.cineme.feature_movie.data.data_source.remote.movie_detail.MovieApiService
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
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() =OkHttpClient.Builder()
        .readTimeout(6, TimeUnit.SECONDS)
        .writeTimeout(6, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideMovieApiService(okHttpClient: OkHttpClient): MovieApiService = Retrofit.Builder()
        .baseUrl("https://imdb8.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build().create(MovieApiService::class.java)

    @Provides
    @Singleton
    fun provideMovieApiDataSource(service: MovieApiService): MovieApiDataSource {
        return MovieApiDataSource(service)
    }


}
