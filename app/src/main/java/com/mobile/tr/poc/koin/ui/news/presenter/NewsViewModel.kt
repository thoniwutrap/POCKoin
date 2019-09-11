package com.mobile.tr.poc.koin.ui.news.presenter

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.tr.poc.koin.ui.news.domain.model.ArticlesItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    private val _selectedID = MutableLiveData<Int>()
    private val author = MutableLiveData<String>()
    val selectedID: LiveData<Int> = _selectedID
    var dataList: MutableList<ArticlesItem> = mutableListOf()
    var mutablePostList = MutableLiveData<MutableList<ArticlesItem>>()

    init {
        _selectedID.value = 1
        author.value = "sss"
    }

    fun toggle(optionID: Int) {
        _selectedID.value = optionID
    }

}