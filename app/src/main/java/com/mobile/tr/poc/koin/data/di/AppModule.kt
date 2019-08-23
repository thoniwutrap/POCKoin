package com.mobile.tr.poc.koin.data.di

import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

val appModule = module {
    single { CompositeDisposable() }
}
