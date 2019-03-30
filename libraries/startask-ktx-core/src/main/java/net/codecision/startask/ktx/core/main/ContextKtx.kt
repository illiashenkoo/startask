package net.codecision.startask.ktx.core.main

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/* Toast */

fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun Context.showToast(@StringRes resId: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resId, length).show()
}

/* Click Controller */

fun Context.isClickAllowed(): Boolean = isClickAllowed()