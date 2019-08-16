package com.mobile.tr.poc.koin.di

import androidx.lifecycle.LifecycleObserver
import com.mobile.tr.poc.koin.BuildConfig
import com.mobile.tr.poc.koin.login.datasource.network.LoginAPI
import com.mobile.tr.poc.koin.network.HeaderInterceptor
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {

    single{ provideOkhttpClient() }
    single { provideRetrofit<LoginAPI>(get())}

}

fun provideOkhttpClient(): OkHttpClient {
    val logger = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    return OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .addInterceptor(logger)
        .followRedirects(true)
        .followSslRedirects(true)
        .retryOnConnectionFailure(true)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .cache(null)
        .build()
}


inline fun <reified T> provideRetrofit(client: OkHttpClient): T {
    return Retrofit.Builder()
        .client(client)
        .baseUrl("https://crm.th.kerryexpress.com/keapp-api/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(T::class.java)
}
