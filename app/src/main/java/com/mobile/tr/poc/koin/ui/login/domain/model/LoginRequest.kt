package com.mobile.tr.poc.koin.ui.login.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginRequest(

		@SerializedName("phoneNumber")
		val mobileNo: String = "",


		@SerializedName("password")
		val password: String = ""

) : Parcelable