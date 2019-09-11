package com.mobile.tr.poc.koin.ui.news.domain.model

import com.google.gson.annotations.SerializedName


data class NewsResponse(

    @field:SerializedName("totalResults")
val totalResults: Int? = null,

    @field:SerializedName("articles")
	val articles: MutableList<ArticlesItem> = mutableListOf(),

    @field:SerializedName("status")
	val status: String? = null
)