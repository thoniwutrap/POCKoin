package com.mobile.tr.poc.koin.ui.github.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mobile.tr.poc.koin.data.local.entity.news.TbNews
import com.mobile.tr.poc.koin.ui.github.domain.model.ArticlesItem

@Dao
interface NewsDao {

	@Insert(onConflict = REPLACE)
	fun upsert(github : TbNews) : Long

	@Query("SELECT * FROM news")
	fun getNewsDB() : MutableList<TbNews>

}

