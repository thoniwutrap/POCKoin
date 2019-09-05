package com.mobile.tr.poc.koin.ui.github.datasource

import com.mobile.tr.poc.koin.ui.github.datasource.local.NewsLocalDataSource
import com.mobile.tr.poc.koin.ui.github.datasource.local.NewsLocalRepository
import com.mobile.tr.poc.koin.ui.github.datasource.network.NewsNetworkDataSource
import com.mobile.tr.poc.koin.ui.github.datasource.network.NewsNetworkRepository
import org.koin.dsl.module


val newsDataModule = module {

    factory<NewsLocalDataSource> { NewsLocalRepository(get()) }
    factory<NewsNetworkDataSource> { NewsNetworkRepository(get()) }
}

