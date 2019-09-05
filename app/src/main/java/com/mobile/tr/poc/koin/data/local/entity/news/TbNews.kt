package com.mobile.tr.poc.koin.data.local.entity.news

import androidx.room.*
import com.mobile.tr.poc.koin.ui.github.domain.model.ArticlesItem

@Entity(tableName = "news")
class TbNews {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    var uid : Int? = null

    @ColumnInfo(name ="totalResults")
    var totalResults: Int? = null

    @TypeConverters(NewsTypeConverters::class)
    var articles: List<ArticlesItem?> = listOf()

    @ColumnInfo(name ="status")
    var status: String? = null
}

