package com.mobile.tr.poc.koin.login.presenter

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var mobileNo : String = ""
    var password : String = ""
    var isEnabled : Boolean = false

    init {
        isEnabled = mobileNo.isNotBlank() && password.isNotBlank()
    }
}