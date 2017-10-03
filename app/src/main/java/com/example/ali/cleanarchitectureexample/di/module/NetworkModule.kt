package com.example.ali.cleanarchitectureexample.di.module

import android.content.Context
import android.content.SharedPreferences
import com.example.ali.cleanarchitectureexample.R
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by ali on 02/10/17.
 */
@Module(includes = arrayOf(AppModule::class))
class NetworkModule(val context: Context){
    @Provides
    @Singleton
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    fun httpClient(logging:HttpLoggingInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()
        return httpClient
    }

    @Provides
    @Singleton
    fun provideCall(httpClient: OkHttpClient): Retrofit {
        val URL = context.getString(R.string.api_url)
        return Retrofit.Builder()
                .baseUrl(URL)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}