package com.mobile.tr.poc.koin.login.datasource

import com.mobile.tr.poc.koin.login.domain.model.LoginResponse
import io.reactivex.Observable

interface LoginDataSource {
    fun login(mobileNo : String,password : String) : Observable<LoginResponse>
}