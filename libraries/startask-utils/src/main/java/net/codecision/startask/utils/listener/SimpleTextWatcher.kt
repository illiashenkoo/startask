package net.codecision.startask.utils.listener

import android.text.Editable
import android.text.TextWatcher

open class SimpleTextWatcher : TextWatcher {

    override fun afterTextChanged(s: Editable) {
        //it's method can be overridden
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        //it's method can be overridden
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        //it's method can be overridden
    }

}