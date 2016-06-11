package com.serguei.kedditbysteps.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.serguei.kedditbysteps.R
import com.serguei.kedditbysteps.commons.ViewType
import com.serguei.kedditbysteps.commons.ViewTypeDelegateAdapter
import com.serguei.kedditbysteps.commons.extensions.inflate

// Created by Serguei Outenkov on 4/24/16.
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)){}
}