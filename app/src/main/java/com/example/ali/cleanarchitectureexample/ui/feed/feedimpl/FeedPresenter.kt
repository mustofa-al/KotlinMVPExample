package com.example.ali.cleanarchitectureexample.ui.feed.feedimpl

import com.example.ali.cleanarchitectureexample.ui.feed.feedcontract.FeedContract
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by ali on 02/10/17.
 */
class FeedPresenter @Inject constructor(val interactor: FeedInteractor): FeedContract.Presenter{

    protected var view: FeedContract.View? = null

    override fun setFeedView(view: FeedContract.View) {
        this.view = view
    }

    override fun getFeedData() {
        interactor.getFeedData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            data -> view?.onSuccessGetFeedData(data)
                        },
                        {
                            e -> view?.showErrorLog(e.message)
                        }
                )
    }

}