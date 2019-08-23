package com.mobile.tr.poc.koin.data.local.query

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mobile.tr.poc.koin.data.local.entity.User

@Dao
interface UserDao {

	@Insert(onConflict = REPLACE)
	fun upsert(user : User) : Long

	@Query("SELECT * FROM user")
	fun getUser() : MutableList<User>

}