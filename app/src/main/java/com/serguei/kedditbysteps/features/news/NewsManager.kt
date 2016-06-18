package com.serguei.kedditbysteps.features.news

import com.serguei.kedditbysteps.commons.RedditNewsItem
import rx.Observable

// Created by Serguei Outenkov on 6/18/16.
class NewsManager(){
    fun getNews(): Observable<List<RedditNewsItem>>{
        return Observable.create {
            subscriber ->
            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10){
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i,
                        1457207701L - i * 200,
                        "http://lorempixel.com/200/200/technics/$i",
                        "url"
                ))
            }
            subscriber.onNext(news)
        }
    }
}