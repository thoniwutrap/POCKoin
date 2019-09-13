package com.mobile.tr.poc.koin.ui.pincode

import com.mobile.tr.poc.koin.ui.pincode.presenter.PinCodeContract
import com.mobile.tr.poc.koin.ui.pincode.presenter.PinCodePresenter
import com.mobile.tr.poc.koin.ui.pincode.presenter.PinCodeViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


var pincodeContributeModule = module {
    viewModel { PinCodeViewModel() }
    factory<PinCodeContract.Presenter> { (view: PinCodeContract.View,viewModel : PinCodeViewModel) -> PinCodePresenter(view,viewModel)}
}