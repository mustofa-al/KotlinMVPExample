package com.example.ali.cleanarchitectureexample.ui.feed.feedimpl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.ali.cleanarchitectureexample.FeedApp
import com.example.ali.cleanarchitectureexample.R
import com.example.ali.cleanarchitectureexample.model.Feed
import com.example.ali.cleanarchitectureexample.ui.feed.adapter.FeedAdapter
import com.example.ali.cleanarchitectureexample.ui.feed.feedcontract.FeedContract
import kotlinx.android.synthetic.main.activity_feed.*
import javax.inject.Inject

class FeedActivity : AppCompatActivity(), FeedContract.View {
    @Inject
    lateinit var presenter: FeedPresenter

    lateinit var adapter:  FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        (application as FeedApp).appComponent?.inject(this)
        adapter = FeedAdapter()
        setupRecyclerView()
        presenter.setFeedView(this)
        presenter.getFeedData()
    }

    private fun setupRecyclerView() {
        rvFeed.setHasFixedSize(true)
        rvFeed.layoutManager = LinearLayoutManager(this)
        rvFeed.adapter = adapter
    }

    override fun showErrorLog(message: String?) {
        Log.d("error load data", message)
    }

    override fun onSuccessGetFeedData(data: List<Feed>?) {
        adapter.setData(data)
    }
}
