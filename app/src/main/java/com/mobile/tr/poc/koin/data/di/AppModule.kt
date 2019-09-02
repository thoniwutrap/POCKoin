package com.mobile.tr.poc.koin.data.di

import com.mobile.tr.poc.koin.login.datasource.network.loginDataSourceNetworkModule
import com.mobile.tr.poc.koin.login.feedModule
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

val appModule = module {
    single { CompositeDisposable() }
}

