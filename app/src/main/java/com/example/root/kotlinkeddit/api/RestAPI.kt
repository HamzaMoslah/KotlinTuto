package com.example.root.kotlinkeddit.api

import com.example.root.kotlinkeddit.models.RedditNewsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

/**
 * Created by root on 10/07/17.
 */
class RestAPI @Inject constructor(private val redditApi: RedditApi): NewsAPI {

    override fun getNews(after: String, limit: String): Call<RedditNewsResponse>{
        return redditApi.getTop(after, limit)
    }
}