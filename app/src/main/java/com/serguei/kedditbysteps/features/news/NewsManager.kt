package com.serguei.kedditbysteps.features.news

import com.serguei.kedditbysteps.api.RestApi
import com.serguei.kedditbysteps.commons.RedditNews
import com.serguei.kedditbysteps.commons.RedditNewsItem
import rx.Observable

// Created by Serguei Outenkov on 6/18/16.
class NewsManager(private val api: RestApi = RestApi()) {

    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
            subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                val dataResponse = response.body().data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments, item.created, item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news
                )
                subscriber.onNext(redditNews)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }

        }
    }
}