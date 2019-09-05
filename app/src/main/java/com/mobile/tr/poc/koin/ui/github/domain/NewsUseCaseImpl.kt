package com.mobile.tr.poc.koin.ui.github.domain

import com.mobile.tr.poc.koin.data.local.entity.news.TbNews
import com.mobile.tr.poc.koin.ui.github.datasource.local.NewsLocalDataSource
import com.mobile.tr.poc.koin.ui.github.datasource.network.NewsNetworkDataSource
import com.mobile.tr.poc.koin.ui.github.domain.model.NewsResponse
import io.reactivex.Observable

class NewsUseCaseImpl(private val remoteSource: NewsNetworkDataSource,
                      private val localSource : NewsLocalDataSource
) : NewsUseCase {


    override fun getNews(apiKey: String): Observable<NewsResponse> {
        return remoteSource.getGithubList(apiKey)
    }

    override fun saveGithubDB(githubUser: TbNews): Long {
        return localSource.saveGithubDB(githubUser)
    }

    override fun getNewsDB(): MutableList<TbNews> {
        return localSource.getNewsDB()
    }

}
