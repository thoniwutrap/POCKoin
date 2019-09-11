package com.mobile.tr.poc.koin.ui.news.datasource.network


import com.mobile.tr.poc.koin.ui.news.domain.model.NewsResponse
import io.reactivex.Observable

interface NewsNetworkDataSource {
    fun getGithubList(apiKey : String) : Observable<NewsResponse>
}