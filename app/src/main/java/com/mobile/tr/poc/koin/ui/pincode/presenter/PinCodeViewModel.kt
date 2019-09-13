package com.mobile.tr.poc.koin.ui.pincode.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.tr.poc.koin.ui.pincode.PinCodeAdapter
import com.mobile.tr.poc.koin.ui.pincode.PinCodeModel
import com.mobile.tr.poc.koin.utils.SingleLiveEvent


class PinCodeViewModel : ViewModel() {

    var pincodeInstance : MutableList<PinCodeModel> = mutableListOf()
    var pincode = SingleLiveEvent<String>()
    var picCodeList = SingleLiveEvent<MutableList<PinCodeModel>>()

    var adapter : PinCodeAdapter? = null
    var maxPin : Int = 8

    init {
        adapter = PinCodeAdapter().apply {
            for (i in 0 until maxPin) {
                pincodeInstance.add(PinCodeModel())
            }
        }.also {
            it.updatePinCode(pincodeInstance)
        }
        pincode.value = ""
    }


}