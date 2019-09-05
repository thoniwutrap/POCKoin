package com.mobile.tr.poc.koin.ui.login.datasource.network

import com.mobile.tr.poc.koin.ui.login.datasource.LoginDataSource
import org.koin.dsl.module

val loginDataSourceNetworkModule = module {

    factory<LoginDataSource> { LoginDataSourceNetwork(get()) }
}

