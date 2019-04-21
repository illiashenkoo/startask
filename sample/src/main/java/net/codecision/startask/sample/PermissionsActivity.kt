package net.codecision.startask.sample

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_permissions.*
import net.codecision.startask.ktx.core.view.setSingleClickListener
import net.codecision.startask.permissions.Permission

class PermissionsActivity : AppCompatActivity() {

    private val locationPermission: Permission by lazy {
        Permission(true, Manifest.permission.CAMERA)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        statusView.text = "Unknown!"

        checkButton.setSingleClickListener {
            checkLocationPermission()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestLocationPermissionResult(requestCode, grantResults)
    }

    @SuppressLint("SetTextI18n")
    private fun checkLocationPermission() {
        locationPermission.check(this)
                .onGranted {
                    statusView.text = "Granted!"
                }.onShowRationale {
                    showRationaleDialog()
                }
    }

    @SuppressLint("SetTextI18n")
    private fun onRequestLocationPermissionResult(requestCode: Int, grantResults: IntArray) {
        locationPermission.onRequestPermissionsResult(this, requestCode, grantResults)
                .onGranted {
                    statusView.text = "Granted!"
                }.onDenied {
                    statusView.text = "Denied!"
                }.onNeverAskAgain {
                    statusView.text = "NeverAskAgain!"
                }
    }

    private fun showRationaleDialog() {
        AlertDialog.Builder(this)
                .setTitle("Camera permission")
                .setMessage("Allow app to use your camera to take photos and record videos.")
                .setPositiveButton("Allow") { _, _ ->
                    locationPermission.request(this)
                }
                .setNegativeButton("Deny") { _, _ ->

                }
                .create()
                .show()
    }

}