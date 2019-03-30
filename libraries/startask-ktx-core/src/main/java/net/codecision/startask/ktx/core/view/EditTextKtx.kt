package net.codecision.startask.ktx.core.view

import android.widget.EditText

fun EditText.getInputtedText(): String {
    return this.text.toString()
}