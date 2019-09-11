package com.mobile.tr.poc.koin.ui.news.domain

import com.mobile.tr.poc.koin.data.local.entity.news.TbNews
import com.mobile.tr.poc.koin.ui.news.domain.model.ArticlesItem
import com.mobile.tr.poc.koin.ui.news.domain.model.NewsResponse
import io.reactivex.Observable

interface NewsUseCase {
    fun getNews(apiKey : String) : Observable<NewsResponse>
    fun saveGithubDB(githubUser: TbNews) : Long
    fun getNewsDB() : MutableList<TbNews>
    fun getArticle(userId : Long) : TbNews
}

