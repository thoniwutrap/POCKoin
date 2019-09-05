package com.mobile.tr.poc.koin.ui.login.datasource

import com.mobile.tr.poc.koin.data.local.entity.User
import io.reactivex.Observable

interface LoginDataSource {
    fun login(mobileNo : String,password : String) : Observable<User>
}