package com.example.ali.cleanarchitectureexample.ui.feed.feedcontract

import com.example.ali.cleanarchitectureexample.model.Feed
import io.reactivex.Observable

/**
 * Created by ali on 02/10/17.
 */
class FeedContract{
    interface View{
        fun showErrorLog(message: String?)
        fun onSuccessGetFeedData(data: List<Feed>?)

    }

    interface Presenter{
        fun getFeedData()

    }

    interface Interactor{
        fun getFeedData(): Observable<List<Feed>>

    }
}