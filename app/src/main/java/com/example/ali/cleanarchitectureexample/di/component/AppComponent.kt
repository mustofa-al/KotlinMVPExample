package com.example.ali.cleanarchitectureexample.di.component

import com.example.ali.cleanarchitectureexample.ui.feed.feedimpl.FeedActivity
import com.example.ali.cleanarchitectureexample.di.module.ApiModule
import com.example.ali.cleanarchitectureexample.di.module.AppModule
import com.example.ali.cleanarchitectureexample.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ali on 02/10/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, ApiModule::class))
interface AppComponent{
    fun inject(feedActivity: FeedActivity)
}