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


    var mutablePostList = MutableLiveData<MutableList<ArticlesItem>>()
    var adapter : NewsAdapter? = null

    init {
        adapter = NewsAdapter()
    }
}