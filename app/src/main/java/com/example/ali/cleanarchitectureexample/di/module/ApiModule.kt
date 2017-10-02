package com.example.ali.cleanarchitectureexample.di.module

import com.example.ali.cleanarchitectureexample.api.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by ali on 02/10/17.
 */
@Module
class ApiModule{
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) = retrofit.create(Api::class.java)
}