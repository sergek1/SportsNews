package com.example.footballmatches.di

import android.app.Application
import androidx.room.Room
import com.example.footballmatches.repository.api.FootballApi
import com.example.footballmatches.repository.database.FootballMatchesDatabase
import com.example.footballmatches.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideFootballApi(retrofit: Retrofit): FootballApi =
        retrofit.create(FootballApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): FootballMatchesDatabase =
        Room.databaseBuilder(app, FootballMatchesDatabase::class.java, "matches_database").build()
}