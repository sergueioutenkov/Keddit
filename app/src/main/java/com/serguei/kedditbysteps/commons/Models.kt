package com.serguei.kedditbysteps.commons

import com.serguei.kedditbysteps.features.news.adapter.AdapterConstants

// Created by Serguei Outenkov on 4/24/16.
data class RedditNews(
        val after: String,
        val before: String,
        val news: List<RedditNewsItem>)

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}