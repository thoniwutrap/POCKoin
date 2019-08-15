package com.mobile.tr.poc.koin

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {

	@POST("v1/Member/Login/Phone")
	fun signInWithMobile(@Body body: LoginRequest): Observable<ResponseBody>


}