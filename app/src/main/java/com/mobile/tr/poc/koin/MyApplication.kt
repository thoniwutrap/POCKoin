package com.mobile.tr.poc.koin

import android.app.Application
import androidx.multidex.MultiDex
import com.mobile.tr.poc.koin.data.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        startKoin {
            androidContext(this@MyApplication)
            androidLogger()
            androidFileProperties()
            modules(
                appModule +
                        networkModule +
                        localModule +
                        contributorModule
            )
        }
    }
}