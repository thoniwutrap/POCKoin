package com.mobile.tr.poc.koin.ui.news.datasource.local

import com.mobile.tr.poc.koin.data.local.entity.news.TbImageNews
import com.mobile.tr.poc.koin.data.local.entity.news.TbNews
import com.mobile.tr.poc.koin.ui.news.domain.model.ArticlesItem

class NewsLocalRepository(private val newsDao: NewsDao,private val imageNewsDao: ImageNewsDao) : NewsLocalDataSource {

    override fun getArticleDB(userId: Long): TbNews {
        return newsDao.getArticleFromID(userId)
    }

    override fun getNewsDB(): MutableList<TbNews> {
        return newsDao.getNewsDB()
    }

    override fun saveGithubDB(githubUser: TbNews): Long {
        return newsDao.upsert(github = githubUser)
    }

    override fun saveImageNewsDB(imgNews: TbImageNews): Long  {
        return imageNewsDao.insertNote(imgNews)
    }


}