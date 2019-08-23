package com.mobile.tr.poc.koin

import android.app.Application
import com.mobile.tr.poc.koin.data.di.appModule
import com.mobile.tr.poc.koin.data.di.localModule
import com.mobile.tr.poc.koin.data.di.networkModule
import com.mobile.tr.poc.koin.login.datasource.network.loginDataSourceNetworkModule
import com.mobile.tr.poc.koin.login.feedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(appModule,networkModule,localModule, feedModule,loginDataSourceNetworkModule))
        }
    }
}