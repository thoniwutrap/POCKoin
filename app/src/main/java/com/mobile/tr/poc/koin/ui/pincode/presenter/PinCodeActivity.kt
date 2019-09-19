package com.mobile.tr.poc.koin.ui.pincode.presenter

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.mobile.tr.poc.koin.R
import com.mobile.tr.poc.koin.databinding.ActivityPinCodeBinding
import com.mobile.tr.poc.koin.extension.showKeyboard
import com.mobile.tr.poc.koin.ui.base.BaseActivity
import com.mobile.tr.poc.koin.ui.pincode.PinCodeModel
import kotlinx.android.synthetic.main.activity_pin_code.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class PinCodeActivity : BaseActivity(),PinCodeContract.View {


    val viewModel: PinCodeViewModel by viewModel()
    val presenter: PinCodeContract.Presenter by inject { parametersOf(this,viewModel) }
    var binding: ActivityPinCodeBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView<ActivityPinCodeBinding>(this, R.layout.activity_pin_code)
                .apply {
                    pincodeViewModel = viewModel
                    lifecycleOwner = this@PinCodeActivity
                }

        edtPinCode.showKeyboard()

        viewModel.pincode.observe(this, Observer {
            presenter.keyPinCode()
        })

        viewModel.picCodeList.observe(this, Observer{
            viewModel.adapter?.updatePinCode(it)
        })
    }

    override fun onKeySuccess(pinCode: String) {
        showLoading()
        //Call API ?????
        toast(pinCode)
    }
}
