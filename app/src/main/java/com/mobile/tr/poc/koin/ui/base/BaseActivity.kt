package com.mobile.tr.poc.koin.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.mobile.tr.poc.koin.dialog.CircularLoadingDialog

open class BaseActivity : AppCompatActivity(),BaseView {


    var progLoading : CircularLoadingDialog? = null


    init {
        progLoading = CircularLoadingDialog.shared()
    }


    override fun showLoading() {
        progLoading?.show(supportFragmentManager,"Loading")
    }

    override fun hideLoading() {
        progLoading?.dismissAllowingStateLoss()
    }



}