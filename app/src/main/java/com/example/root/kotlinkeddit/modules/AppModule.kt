package com.example.root.kotlinkeddit.modules

import android.content.Context
import com.example.root.kotlinkeddit.KedditApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by root on 12/07/17.
 */
@Module
class AppModule(val app: KedditApp) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app;
    }

    @Provides
    @Singleton
    fun provideApplication(): KedditApp {
        return app;
    }
}