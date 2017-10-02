package com.example.ali.cleanarchitectureexample.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ali on 02/10/17.
 */
@Module
class AppModule(val application: Application){
    @Provides
    @Singleton
    fun provideApplication(): Context = application

    @Provides
    @Singleton
    fun provideAppContext(): Context = application.applicationContext
}