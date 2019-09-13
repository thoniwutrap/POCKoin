package com.mobile.tr.poc.koin.ui.pincode

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.mobile.tr.poc.koin.R
import com.mobile.tr.poc.koin.databinding.ActivityPinCodeBinding
import com.mobile.tr.poc.koin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_pin_code.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class PinCodeActivity : BaseActivity() {

    val viewModel: PinCodeViewModel by viewModel()
    var binding: ActivityPinCodeBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView<ActivityPinCodeBinding>(this, R.layout.activity_pin_code)
                .apply {
                    pincodeViewModel = viewModel
                    lifecycleOwner = this@PinCodeActivity
                }

        openSoftKeyboard(this, edtPinCode)

        viewModel.pincode.observe(this, Observer { pin ->
            Toast.makeText(this, "$pin length=${pin.length}", Toast.LENGTH_SHORT).show()
            pin.length.let { length ->
                if (length != 0) {
                    viewModel.pincodeInstance.forEachIndexed { index, element ->
                        if (index + 1 > length)
                            element.isEnable = false
                    }
                    viewModel.pincodeInstance[length - 1].isEnable = true

                } else {
                    viewModel.pincodeInstance[0].isEnable = false
                }
                viewModel.picCodeList.postValue(viewModel.pincodeInstance)
            }
        })


        viewModel.picCodeList.observe(this, Observer<MutableList<PinCodeModel>> {
            viewModel.adapter?.updatePinCode(it)
        })
    }

    fun openSoftKeyboard(context: Context, view: View) {
        view.requestFocus()
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
}
