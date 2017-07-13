package com.example.root.kotlinkeddit

import android.app.Application
import com.example.root.kotlinkeddit.modules.AppModule
import com.example.root.kotlinkeddit.modules.DaggerNewsComponent
import com.example.root.kotlinkeddit.modules.NewsComponent

/**
 * Created by root on 12/07/17.
 */
class KedditApp : Application() {

    companion object {
        val newsComponent: NewsComponent by lazy {
            DaggerNewsComponent.builder().appModule(AppModule(KedditApp())).build()
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}