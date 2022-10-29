package com.example.foodapp.di

import com.example.foodapp.data.repo.IslemlerRepo
import com.example.foodapp.retrofit.ApiUtils
import com.example.foodapp.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideIslemlerRepo(ydao:YemeklerDao) : IslemlerRepo {
        return IslemlerRepo(ydao)
    }

    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDao {
        return ApiUtils.getYemeklerDao()
    }
}