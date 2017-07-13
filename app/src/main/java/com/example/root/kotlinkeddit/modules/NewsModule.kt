package com.example.root.kotlinkeddit.modules

import com.example.root.kotlinkeddit.api.NewsAPI
import com.example.root.kotlinkeddit.api.RedditApi
import com.example.root.kotlinkeddit.api.RestAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by root on 12/07/17.
 */
@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsAPI(redditApi: RedditApi): NewsAPI {
        return RestAPI(redditApi)
    }

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditApi {
        return retrofit.create(RedditApi::class.java)
    }
}