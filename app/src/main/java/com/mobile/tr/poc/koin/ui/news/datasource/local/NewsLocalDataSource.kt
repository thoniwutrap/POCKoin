package com.mobile.tr.poc.koin.ui.news.datasource.local

import com.mobile.tr.poc.koin.data.local.entity.news.TbNews
import com.mobile.tr.poc.koin.ui.news.domain.model.ArticlesItem

interface NewsLocalDataSource {
    fun saveGithubDB(githubUser: TbNews) : Long
    fun getNewsDB() : MutableList<TbNews>
    fun getArticleDB(userId : Long) : TbNews
}