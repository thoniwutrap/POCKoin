package com.mobile.tr.poc.koin.login.presenter

interface LoginContract {

    interface View {
    }

    interface Presenter {
        fun login()
        fun getUser()
    }
}