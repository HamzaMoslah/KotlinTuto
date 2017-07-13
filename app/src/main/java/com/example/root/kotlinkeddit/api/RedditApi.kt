package com.example.root.kotlinkeddit.api

import com.example.root.kotlinkeddit.models.RedditNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by root on 10/07/17.
 */
interface RedditApi {
    @GET("/top.json")
    fun getTop(@Query("after") after: String,
        @Query("limit") limit: String): Call<RedditNewsResponse>;
}