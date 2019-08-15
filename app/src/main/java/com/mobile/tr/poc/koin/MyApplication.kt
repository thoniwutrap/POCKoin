package com.mobile.tr.poc.koin

import android.app.Application
import com.mobile.tr.poc.koin.di.feedModule
import com.mobile.tr.poc.koin.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(networkModule, feedModule))
        }
    }
}