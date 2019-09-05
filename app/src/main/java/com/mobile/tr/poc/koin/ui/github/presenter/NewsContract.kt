package com.mobile.tr.poc.koin.ui.github.presenter

import androidx.lifecycle.LifecycleObserver

interface NewsContract {

    interface View : NewsContract{
    }

    interface Presenter : LifecycleObserver {
        fun getGithub()
        fun getNews()
    }
}