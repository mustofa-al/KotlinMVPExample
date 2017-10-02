package com.example.ali.cleanarchitectureexample.ui.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ali.cleanarchitectureexample.R
import com.example.ali.cleanarchitectureexample.model.Feed
import kotlinx.android.synthetic.main.feed_card.view.*

/**
 * Created by ali on 02/10/17.
 */
class FeedAdapter: RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    var datas: MutableList<Feed> = ArrayList()

    inner class FeedViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title = view.tvTtitle
        val body = view.tvBody
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent?.getContext()).inflate(R.layout.feed_card, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.title.text = datas[position].title
        holder.body.text = datas[position].body?.substring(100)
    }

    override fun getItemCount() = datas.size

    fun setData(data: List<Feed>?){
        datas = data!!.toMutableList()
        notifyDataSetChanged()
    }

}