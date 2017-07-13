package com.example.root.kotlinkeddit.modules

import com.example.root.kotlinkeddit.fragments.NewsFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by root on 12/07/17.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {

    fun inject(newsFragment: NewsFragment)

}