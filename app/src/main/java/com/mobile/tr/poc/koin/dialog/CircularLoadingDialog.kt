package com.mobile.tr.poc.koin.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.mobile.tr.poc.koin.R

class CircularLoadingDialog : DialogFragment() {


    companion object {
        fun shared(): CircularLoadingDialog {
            val dialog = CircularLoadingDialog()
            dialog.isCancelable = true
            return dialog
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.dialog_circular_loading, container, true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return view
    }

}