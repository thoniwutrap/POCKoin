package com.mobile.tr.poc.koin.login.datasource

import com.mobile.tr.poc.koin.login.datasource.network.LoginAPI
import com.mobile.tr.poc.koin.login.domain.model.LoginRequest
import io.reactivex.Observable
import okhttp3.ResponseBody


class LoginRepository constructor(private val dataSource : LoginDataSource) : LoginDataSource by dataSource