package com.mobile.tr.poc.koin.ui.news.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobile.tr.poc.koin.data.local.entity.news.TbImageNews

@Dao
interface ImageNewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: TbImageNews): Long

    @Query("SELECT * FROM ImageNews")
    fun findAllNotedObservable(): MutableList<TbImageNews>

}

