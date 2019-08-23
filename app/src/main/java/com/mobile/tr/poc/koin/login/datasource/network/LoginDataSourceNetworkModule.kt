package com.mobile.tr.poc.koin.login.datasource.network

import com.mobile.tr.poc.koin.login.datasource.LoginDataSource
import com.mobile.tr.poc.koin.login.datasource.LoginRepository
import org.koin.dsl.module

val loginDataSourceNetworkModule = module {

    factory<LoginDataSource> { LoginDataSourceNetwork(get()) }
}

