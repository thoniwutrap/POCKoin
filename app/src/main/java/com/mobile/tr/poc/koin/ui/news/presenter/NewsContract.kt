package com.mobile.tr.poc.koin.ui.news.presenter

import androidx.lifecycle.LifecycleObserver
import com.mobile.tr.poc.koin.ui.news.domain.model.NewsResponse

interface NewsContract {

    interface View : NewsContract{
        fun onNewsSuccess()
        fun onOfflineMode()
    }


    interface Presenter : LifecycleObserver {
        fun getGithub()
        fun getNewsOffline()
        fun getNews()
    }
}