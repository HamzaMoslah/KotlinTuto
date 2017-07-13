package com.example.root.kotlinkeddit.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.root.kotlinkeddit.fragments.ViewType

/**
 * Created by root on 05/07/17.
 */
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)

}