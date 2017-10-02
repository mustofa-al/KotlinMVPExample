package com.example.ali.cleanarchitectureexample.api

import com.example.ali.cleanarchitectureexample.model.Feed
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by ali on 02/10/17.
 */
interface Api{
    @GET("/posts")
    fun getPosts(): Observable<List<Feed>>
}