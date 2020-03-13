package com.mobile.tr.poc.koin.ui.paging.network

import com.mobile.tr.poc.koin.ui.news.domain.model.NewsResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines")
    suspend fun getNews(@Query("sources") sources : String = "techcrunch",
                @Query("apiKey") apiKey : String
    ): Response<NewsResponse>


}