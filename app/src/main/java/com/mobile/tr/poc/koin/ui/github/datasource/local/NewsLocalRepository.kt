package com.mobile.tr.poc.koin.ui.github.datasource.local

import com.mobile.tr.poc.koin.data.local.entity.news.TbNews

class NewsLocalRepository(private val newsDao: NewsDao) : NewsLocalDataSource {

    override fun getNewsDB(): MutableList<TbNews> {
        return newsDao.getNewsDB()
    }

    override fun saveGithubDB(githubUser: TbNews): Long {
        return newsDao.upsert(github = githubUser)
    }
}