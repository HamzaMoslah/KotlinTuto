package com.example.root.kotlinkeddit.api

import com.example.root.kotlinkeddit.models.RedditNewsResponse
import retrofit2.Call

/**
 * Created by root on 11/07/17.
 */
interface NewsAPI {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}