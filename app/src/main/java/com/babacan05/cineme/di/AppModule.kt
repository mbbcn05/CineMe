package com.babacan05.cineme.di

import com.babacan05.cineme.feature_movie.data.repository.IMDBApiService
import com.babacan05.cineme.feature_movie.domain.repository.SearchMoviesRepository
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
    fun provideRetrofitService(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://imdb8.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build().create(SearchMoviesRepository::class.java)

}



