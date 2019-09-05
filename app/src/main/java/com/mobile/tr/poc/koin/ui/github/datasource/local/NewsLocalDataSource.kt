package com.mobile.tr.poc.koin.ui.github.datasource.local

import com.mobile.tr.poc.koin.data.local.entity.news.TbNews

interface NewsLocalDataSource {
    fun saveGithubDB(githubUser: TbNews) : Long
    fun getNewsDB() : MutableList<TbNews>
}