package com.mobile.tr.poc.koin.login.datasource.network

import com.mobile.tr.poc.koin.login.datasource.LoginDataSource
import com.mobile.tr.poc.koin.login.domain.model.LoginRequest
import com.mobile.tr.poc.koin.login.domain.model.LoginResponse
import io.reactivex.Observable

class LoginDataSourceNetwork (val api : LoginAPI) : LoginDataSource {

    override fun login(mobileNo: String, password: String): Observable<LoginResponse> {
        return api.signInWithMobile(LoginRequest(mobileNo = mobileNo, password = password))
    }
}