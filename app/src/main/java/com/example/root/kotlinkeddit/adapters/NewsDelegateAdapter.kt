package com.example.root.kotlinkeddit.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.root.kotlinkeddit.*
import com.example.root.kotlinkeddit.extensions.getFriendlyTime
import com.example.root.kotlinkeddit.extensions.inflate
import com.example.root.kotlinkeddit.extensions.loadImg
import com.example.root.kotlinkeddit.fragments.ViewType
import com.example.root.kotlinkeddit.models.RedditNewsItem
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by root on 05/07/17.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup): RecyclerView.ViewHolder (parent.inflate(R.layout.news_item)){
        fun bind(item: RedditNewsItem) = with(itemView){
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }
}