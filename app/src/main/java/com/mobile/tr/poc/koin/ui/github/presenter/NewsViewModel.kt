package com.mobile.tr.poc.koin.ui.github.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.tr.poc.koin.ui.github.domain.model.ArticlesItem

class NewsViewModel : ViewModel() {

    private val _selectedID = MutableLiveData<Int>()
    private val author = MutableLiveData<String>()
    val selectedID: LiveData<Int> = _selectedID

    init {
        _selectedID.value = 1
        author.value = "sss"
    }

    fun toggle(optionID: Int) {
        _selectedID.value = optionID
    }
}