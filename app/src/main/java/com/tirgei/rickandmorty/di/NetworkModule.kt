package com.tirgei.rickandmorty.di

import com.google.gson.Gson
import com.tirgei.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

//    @Provides
//    @Singleton
//    fun provideApiService(): ApiService {
//        val logger = HttpLoggingInterceptor {
//            Timber.i("API REQUEST: $it")
//        }
//        logger.level = HttpLoggingInterceptor.Level.BODY
//
//        val client = OkHttpClient.Builder()
////        if (BuildConfig.DEBUG) {
////            client.addInterceptor(logger)
////        }
//
//        return Retrofit.Builder()
//            .baseUrl("")
//            .client(client.build())
//            .addConverterFactory(GsonConverterFactory.create(Gson()))
//            .build()
//            .create(ApiService::class.java)
//    }

}