package com.mobile.tr.poc.koin.user

import com.mobile.tr.poc.koin.LoginAPI
import com.mobile.tr.poc.koin.LoginRequest
import io.reactivex.Observable
import okhttp3.ResponseBody

interface UsersRepository {
    fun getFeed(): Observable<ResponseBody>
}

class UsersRepositoryImpl(private val api: LoginAPI) : UsersRepository {

    override fun getFeed(): Observable<ResponseBody> {
        return api.signInWithMobile(LoginRequest("0909866888","123456"))
    }
}