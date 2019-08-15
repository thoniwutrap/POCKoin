package com.mobile.tr.poc.koin

import android.app.Application
import com.mobile.tr.poc.koin.login.feedModule
import com.mobile.tr.poc.koin.di.networkModule
import com.mobile.tr.poc.koin.login.datasource.network.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(networkModule, feedModule,loginModule))
        }
    }
}