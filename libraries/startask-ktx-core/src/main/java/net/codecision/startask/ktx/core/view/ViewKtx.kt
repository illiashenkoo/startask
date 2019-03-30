package net.codecision.startask.ktx.core.view

import android.view.View
import net.codecision.startask.ktx.core.utils.ClickController

fun View.setSingleClickListener(listener: (v: View) -> Unit) {
    this.setOnClickListener {
        if (ClickController.isClickAllowed()) {
            listener(this)
        }
    }
}