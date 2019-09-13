package com.mobile.tr.poc.koin.ui.pincode

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PinCodeViewModel : ViewModel() {

    var pincodeInstance : MutableList<PinCodeModel> = mutableListOf()

    var pinColor : Int = Color.BLUE

    var pincode = MutableLiveData<String>()
    var picCodeList = MutableLiveData<MutableList<PinCodeModel>>()

    var adapter : PinCodeAdapter? = null
    var maxPin : Int = 6

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