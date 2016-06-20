package com.serguei.kedditbysteps.features.news

import com.serguei.kedditbysteps.api.RestApi
import com.serguei.kedditbysteps.commons.RedditNewsItem
import rx.Observable

// Created by Serguei Outenkov on 6/18/16.
class NewsManager(private val api: RestApi = RestApi()) {
    fun getNews(limit: String = "10"): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber ->
            val callResponse = api.getNews("", limit)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                val news = response.body().data.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments, item.created, item.thumbnail, item.url)
                }
                subscriber.onNext(news)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }

        }
    }
}