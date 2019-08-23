package com.mobile.tr.poc.koin.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "user")
class User{

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "uid")
	var uid : Int? = null

	@ColumnInfo(name = "accessToken")
	@SerializedName("access_token")
	var accessToken : String? = null

	@ColumnInfo(name = "refreshToken")
	@SerializedName("refresh_token")
	var refreshToken : String? = null

	@ColumnInfo(name = "tokenType")
	@SerializedName("token_type")
	var tokenType : String? = null


}
