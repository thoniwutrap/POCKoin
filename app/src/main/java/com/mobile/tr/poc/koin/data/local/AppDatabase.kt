package com.mobile.tr.poc.koin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mobile.tr.poc.koin.data.local.entity.news.TbNews
import com.mobile.tr.poc.koin.data.local.entity.User
import com.mobile.tr.poc.koin.data.local.entity.news.NewsTypeConverters
import com.mobile.tr.poc.koin.data.local.entity.news.TbImageNews
import com.mobile.tr.poc.koin.data.local.query.UserDao
import com.mobile.tr.poc.koin.ui.news.datasource.local.ImageNewsDao
import com.mobile.tr.poc.koin.ui.news.datasource.local.NewsDao


@Database(
		entities = [
			User::class,
			TbNews::class,
			TbImageNews::class],
		version = 3
)
@TypeConverters(NewsTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
	abstract fun userDao(): UserDao
	abstract fun githubUser() : NewsDao
	abstract fun imageNewsDao() : ImageNewsDao
}