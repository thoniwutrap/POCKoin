package com.mobile.tr.poc.koin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobile.tr.poc.koin.data.local.entity.User
import com.mobile.tr.poc.koin.data.local.query.UserDao


@Database(
		entities = [User::class],
		version = 1
)
abstract class AppDatabase : RoomDatabase() {
	abstract fun userDao(): UserDao
}