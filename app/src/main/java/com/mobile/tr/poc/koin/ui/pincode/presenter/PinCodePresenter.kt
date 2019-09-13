package com.mobile.tr.poc.koin.ui.pincode.presenter

import android.util.Log

class PinCodePresenter constructor(
    var view: PinCodeContract.View?,
    var viewModel : PinCodeViewModel
) : PinCodeContract.Presenter{

    override fun keyPinCode() {
        Log.e("d","xcxc")
        viewModel.pincode.value.toString().length.let { length ->
            if (length != 0) {
                viewModel.pincodeInstance.forEachIndexed { index, element ->
                    if (index + 1 > length)
                        element.isEnable = false
                }
                viewModel.pincodeInstance[length - 1].isEnable = true
            } else {
                viewModel.pincodeInstance[0].isEnable = false
            }
            viewModel.picCodeList.value = viewModel.pincodeInstance
            if(length == viewModel.maxPin){
                view?.onKeySuccess(viewModel.pincode.value.toString())
            }
        }
    }
}