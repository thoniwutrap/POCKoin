package com.mobile.tr.poc.koin.ui.github.domain.model

import com.google.gson.annotations.SerializedName


data class Source(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)