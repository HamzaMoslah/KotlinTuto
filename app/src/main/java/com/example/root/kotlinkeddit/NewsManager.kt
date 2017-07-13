package com.example.root.kotlinkeddit

import com.example.root.kotlinkeddit.api.NewsAPI
import com.example.root.kotlinkeddit.api.RestAPI
import com.example.root.kotlinkeddit.models.RedditNews
import com.example.root.kotlinkeddit.models.RedditNewsItem
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by root on 07/07/17.
 */
@Singleton
class NewsManager @Inject constructor(private val api: NewsAPI) {
    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
            Subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful){
                val dataResponse = response.body().data
                val news = dataResponse.children.map{
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news
                )
                Subscriber.onNext(redditNews)
                Subscriber.onCompleted()
            }else{
                Subscriber.onError(Throwable(response.message()))
            }
        }
    }
}