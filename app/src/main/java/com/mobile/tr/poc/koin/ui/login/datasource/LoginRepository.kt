package com.mobile.tr.poc.koin.ui.login.datasource


class LoginRepository constructor(private val dataSource : LoginDataSource) : LoginDataSource by dataSource