package com.mobile.tr.poc.koin.ui.news.datasource

import com.mobile.tr.poc.koin.ui.news.datasource.local.NewsLocalDataSource
import com.mobile.tr.poc.koin.ui.news.datasource.local.NewsLocalRepository
import com.mobile.tr.poc.koin.ui.news.datasource.network.NewsNetworkDataSource
import com.mobile.tr.poc.koin.ui.news.datasource.network.NewsNetworkRepository
import org.koin.dsl.module


val newsDataModule = module {
    factory<NewsLocalDataSource> { NewsLocalRepository(get(),get()) }
    factory<NewsNetworkDataSource> { NewsNetworkRepository(get()) }
}

