package com.mobile.tr.poc.koin.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobile.tr.poc.koin.dialog.CircularLoadingDialog

open class BaseActivity : AppCompatActivity(),BaseView {
    override fun toast(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }


    var progLoading : CircularLoadingDialog? = null


    init {

        progLoading = CircularLoadingDialog.shared()
    }


    override fun showLoading() {
        try {
            progLoading?.show(supportFragmentManager, "Loading")
        }catch (ex : Exception){
            ex.printStackTrace()
        }
    }

    override fun hideLoading() {
        progLoading?.dismissAllowingStateLoss()
    }



}