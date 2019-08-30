package com.mobile.tr.poc.koin.test

import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {


    @GET("users/{username}")
     suspend fun user(@Path("username")  username : String): UsersResponse

}