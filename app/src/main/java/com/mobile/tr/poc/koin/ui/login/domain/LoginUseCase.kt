package com.mobile.tr.poc.koin.ui.login.domain

import com.mobile.tr.poc.koin.data.local.entity.User
import com.mobile.tr.poc.koin.ui.login.datasource.LoginDataSource
import com.mobile.tr.poc.koin.ui.login.domain.model.LoginRequest
import io.reactivex.Observable


interface LoginUseCase {
    fun login(request: LoginRequest): Observable<User>
}

class LoginUseCaseImpl(private val remoteSource: LoginDataSource) : LoginUseCase {

    override fun login(request: LoginRequest): Observable<User> {
        return remoteSource.login(request.mobileNo,request.password)
    }
}