package com.mobile.tr.poc.koin.ui.login.datasource.network

import com.mobile.tr.poc.koin.data.local.entity.User
import com.mobile.tr.poc.koin.ui.login.datasource.LoginDataSource
import com.mobile.tr.poc.koin.ui.login.domain.model.LoginRequest
import io.reactivex.Observable

class LoginDataSourceNetwork (val api : LoginAPI) : LoginDataSource {

    override fun login(mobileNo: String, password: String): Observable<User> {
        return api.signInWithMobile(LoginRequest(mobileNo = mobileNo, password = password))
    }
}