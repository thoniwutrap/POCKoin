package com.mobile.tr.poc.koin.ui.pincode

import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


var pincodeContributeModule = module {
    viewModel { PinCodeViewModel() }
}