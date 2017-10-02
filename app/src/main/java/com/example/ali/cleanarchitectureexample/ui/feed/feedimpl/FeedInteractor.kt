package com.example.ali.cleanarchitectureexample.ui.feed.feedimpl

import com.example.ali.cleanarchitectureexample.api.Api
import com.example.ali.cleanarchitectureexample.model.Feed
import com.example.ali.cleanarchitectureexample.ui.feed.feedcontract.FeedContract
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ali on 02/10/17.
 */
class FeedInteractor @Inject constructor(val api: Api): FeedContract.Interactor{
    override fun getFeedData() = api.getPosts()
}