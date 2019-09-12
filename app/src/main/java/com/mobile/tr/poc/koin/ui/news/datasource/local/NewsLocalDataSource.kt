package com.mobile.tr.poc.koin.ui.news.datasource.local

import com.mobile.tr.poc.koin.data.local.entity.news.TbImageNews
import com.mobile.tr.poc.koin.data.local.entity.news.TbNews
import com.mobile.tr.poc.koin.ui.news.domain.model.ArticlesItem

interface NewsLocalDataSource {
    //News
    fun saveGithubDB(githubUser: TbNews) : Long
    fun getNewsDB() : MutableList<TbNews>
    fun getArticleDB(userId : Long) : TbNews

    //Image News
    fun saveImageNewsDB(imgNews : TbImageNews) : Long


}