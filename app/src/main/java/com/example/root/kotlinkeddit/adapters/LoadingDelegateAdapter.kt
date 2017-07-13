package com.example.root.kotlinkeddit.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.root.kotlinkeddit.R
import com.example.root.kotlinkeddit.fragments.ViewType
import com.example.root.kotlinkeddit.extensions.inflate

/**
 * Created by root on 05/07/17.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }
}