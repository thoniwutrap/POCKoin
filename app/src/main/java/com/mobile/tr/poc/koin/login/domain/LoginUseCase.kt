package com.mobile.tr.poc.koin.login.domain

import com.mobile.tr.poc.koin.LoginRequest
import com.mobile.tr.poc.koin.login.datasource.LoginRepository
import io.reactivex.Observable
import okhttp3.ResponseBody


interface LoginUseCase {
    fun execute(request: LoginRequest): Observable<ResponseBody>
}

class LoginUseCaseImpl(private val repository: LoginRepository) : LoginUseCase {

    override fun execute(request: LoginRequest): Observable<ResponseBody> {
        return repository.getFeed(request.mobileNo,request.password)
    }
}