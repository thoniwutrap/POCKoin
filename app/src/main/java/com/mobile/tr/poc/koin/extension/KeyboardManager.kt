package com.mobile.tr.poc.koin.extension

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

internal fun EditText.showKeyboard() {
    this.requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}
