package com.mobile.tr.poc.koin.login.datasource

import com.mobile.tr.poc.koin.LoginAPI
import com.mobile.tr.poc.koin.LoginRequest
import io.reactivex.Observable
import okhttp3.ResponseBody


interface LoginRepository {
    fun getFeed(mobileNo : String, password : String): Observable<ResponseBody>
}

class LoginRepositoryImpl(private val api: LoginAPI) : LoginRepository {

    override fun getFeed(mobileNo: String, password: String): Observable<ResponseBody> {
        return api.signInWithMobile(LoginRequest(mobileNo,password))
    }
}