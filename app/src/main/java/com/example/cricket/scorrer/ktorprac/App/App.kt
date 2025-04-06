package com.example.cricket.scorrer.ktorprac.App

import android.app.Application
import com.example.cricket.scorrer.ktorprac.Di.KoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module


class App:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(KoinModule)
        }

    }
}