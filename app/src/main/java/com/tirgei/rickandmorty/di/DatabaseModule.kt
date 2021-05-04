package com.tirgei.rickandmorty.di

import android.content.Context
import androidx.room.Room
import com.tirgei.data.cache.AppDatabase
import com.tirgei.data.cache.dao.CharactersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "rick_and_morty")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCharactersDao(appDatabase: AppDatabase): CharactersDao {
        return appDatabase.charactersDao()
    }

}