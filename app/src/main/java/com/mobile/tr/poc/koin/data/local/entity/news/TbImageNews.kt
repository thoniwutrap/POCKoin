package com.mobile.tr.poc.koin.data.local.entity.news

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo


@Entity(tableName = "ImageNews",foreignKeys = [ForeignKey(entity = TbNews::class,
    parentColumns = ["uid"],
    childColumns = ["news_uid"],
    onDelete = ForeignKey.NO_ACTION,
    onUpdate = ForeignKey.CASCADE)]
)
class TbImageNews{


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null

    @ColumnInfo(name = "news_uid")
    var newsUid: Int? = null

    @ColumnInfo(name = "imgUrl")
    var imgUrl: String? = null

}
