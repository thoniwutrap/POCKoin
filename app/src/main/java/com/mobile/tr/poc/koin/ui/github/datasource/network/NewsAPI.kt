package com.mobile.tr.poc.koin.ui.github.datasource.network

import com.mobile.tr.poc.koin.ui.github.domain.model.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines")
    fun getNews(@Query("sources") sources : String = "techcrunch",
               @Query("apiKey") apiKey : String
               ): Observable<NewsResponse>

}