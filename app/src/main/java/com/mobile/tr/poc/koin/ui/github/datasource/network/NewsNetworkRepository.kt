package com.mobile.tr.poc.koin.ui.github.datasource.network

import com.mobile.tr.poc.koin.ui.github.domain.model.NewsResponse
import io.reactivex.Observable

class NewsNetworkRepository(private val api: NewsAPI) : NewsNetworkDataSource {

    override fun getGithubList(apiKey: String): Observable<NewsResponse> {
        return api.getNews(apiKey = apiKey)
    }
}