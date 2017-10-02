package com.example.ali.cleanarchitectureexample

import android.app.Application
import com.example.ali.cleanarchitectureexample.di.component.AppComponent
import com.example.ali.cleanarchitectureexample.di.component.DaggerAppComponent
import com.example.ali.cleanarchitectureexample.di.module.AppModule
import com.example.ali.cleanarchitectureexample.di.module.NetworkModule

/**
 * Created by ali on 02/10/17.
 */
class FeedApp: Application(){
    var appComponent: AppComponent? = null
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(this))
                .build()
    }
}