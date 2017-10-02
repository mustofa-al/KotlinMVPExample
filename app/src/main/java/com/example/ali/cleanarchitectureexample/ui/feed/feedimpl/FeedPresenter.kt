package com.example.ali.cleanarchitectureexample.ui.feed.feedimpl

import com.example.ali.cleanarchitectureexample.ui.feed.feedcontract.FeedContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ali on 02/10/17.
 */
class FeedPresenter(val view: FeedContract.View, val interactor: FeedContract.Interactor): FeedContract.Presenter{
    override fun getFeedData() {
        interactor.getFeedData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            data -> view.onSuccessGetFeedData(data)
                        },
                        {
                            e -> view.showErrorLog(e.message)
                        }
                )
    }

}