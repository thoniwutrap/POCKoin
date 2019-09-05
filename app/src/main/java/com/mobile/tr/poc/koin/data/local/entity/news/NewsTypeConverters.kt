package com.mobile.tr.poc.koin.data.local.entity.news

import androidx.room.TypeConverter
import java.util.Collections.emptyList
import com.google.gson.Gson
import com.mobile.tr.poc.koin.ui.github.domain.model.ArticlesItem


class NewsTypeConverters {

    @TypeConverter
    fun listToJson(value: List<ArticlesItem>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<ArticlesItem>? {
        val objects = Gson().fromJson(value, Array<ArticlesItem>::class.java) as Array<ArticlesItem>
        val list = objects.toList()
        return list
    }
}