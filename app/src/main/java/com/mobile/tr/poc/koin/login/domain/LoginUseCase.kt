package com.mobile.tr.poc.koin.login.domain

import com.mobile.tr.poc.koin.login.datasource.LoginDataSource
import com.mobile.tr.poc.koin.login.domain.model.LoginRequest
import com.mobile.tr.poc.koin.login.datasource.LoginRepository
import com.mobile.tr.poc.koin.login.domain.model.LoginResponse
import io.reactivex.Observable
import okhttp3.ResponseBody


interface LoginUseCase {
    fun execute(request: LoginRequest): Observable<LoginResponse>
}

class LoginUseCaseImpl(private val remoteSource: LoginDataSource) : LoginUseCase {

    override fun execute(request: LoginRequest): Observable<LoginResponse> {
        return remoteSource.login(request.mobileNo,request.password)
    }
}