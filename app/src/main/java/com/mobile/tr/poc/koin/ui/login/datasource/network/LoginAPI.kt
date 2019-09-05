package com.mobile.tr.poc.koin.ui.login.datasource.network

import com.mobile.tr.poc.koin.data.local.entity.User
import com.mobile.tr.poc.koin.ui.login.domain.model.LoginRequest
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {

	@POST("v1/Member/Login/Phone")
	fun signInWithMobile(@Body body: LoginRequest): Observable<User>

}