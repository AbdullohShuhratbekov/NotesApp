package com.example.project

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


fun EditText?.showKeyboard() {
    this ?: return
    requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager ?: return
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}