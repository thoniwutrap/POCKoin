package com.mobile.tr.poc.koin.ui.pincode.presenter

import androidx.lifecycle.LifecycleObserver

interface PinCodeContract {

    interface View : PinCodeContract {
        fun onKeySuccess(pinCode : String)
    }

    interface Presenter : LifecycleObserver {
        fun keyPinCode()
    }
}