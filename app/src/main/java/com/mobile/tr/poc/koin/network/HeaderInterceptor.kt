package com.mobile.tr.poc.koin.network


import okhttp3.*

class HeaderInterceptor : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("app_id", "ke_app")
                .addHeader("app_key", "69250a49-999f-4138-9283-35e90ff2b911")
                .addHeader("version", "5.0.0")
                .addHeader("os","Android").build()
        )
    }


}