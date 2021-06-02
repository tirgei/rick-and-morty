package com.tirgei.rickandmorty.di

import com.tirgei.data.cache.dao.CharactersDao
import com.tirgei.data.remote.ApiService
import com.tirgei.data.repositories.CharactersRepository
import com.tirgei.domain.repositories.ICharactersRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharactersRepository(
        apiService: ApiService,
        dao: CharactersDao
    ) = CharactersRepository(apiService, dao)

}