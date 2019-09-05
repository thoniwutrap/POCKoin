package com.mobile.tr.poc.koin.ui.github.datasource.network


import com.mobile.tr.poc.koin.ui.github.domain.model.NewsResponse
import io.reactivex.Observable

interface NewsNetworkDataSource {
    fun getGithubList(apiKey : String) : Observable<NewsResponse>
}