package net.codecision.startask.permissions

import android.app.Activity
import androidx.fragment.app.Fragment
import net.codecision.startask.permissions.model.PermissionCheckResult
import net.codecision.startask.permissions.model.PermissionRequestResult

class Permission constructor(
        private val requestCode: Int,
        private val shouldShowRationale: Boolean,
        private vararg val permissions: String
) {

    constructor(
            shouldShowRationale: Boolean,
            vararg permissions: String
    ) : this(
            PERMISSIONS_REQUEST_CODE,
            shouldShowRationale,
            *permissions
    )

    fun check(activity: Activity): PermissionCheckResult {
        return PermissionUtils.checkPermissions(activity, permissions, requestCode, shouldShowRationale)
    }

    fun check(fragment: Fragment): PermissionCheckResult {
        return PermissionUtils.checkPermissions(fragment, permissions, requestCode, shouldShowRationale)
    }

    fun request(activity: Activity) {
        return PermissionUtils.requestPermissions(activity, permissions, requestCode)
    }

    fun request(fragment: Fragment) {
        return PermissionUtils.requestPermissions(fragment, permissions, requestCode)
    }

    fun onRequestPermissionsResult(
            fragment: Fragment,
            requestCode: Int,
            grantResults: IntArray
    ): PermissionRequestResult {
        return if (requestCode == this.requestCode) {
            PermissionUtils.onRequestPermissionsResult(fragment, grantResults, permissions)
        } else {
            PermissionRequestResult.getIncorrectCode()
        }
    }

    fun onRequestPermissionsResult(
            activity: Activity,
            requestCode: Int,
            grantResults: IntArray
    ): PermissionRequestResult {
        return if (requestCode == this.requestCode) {
            PermissionUtils.onRequestPermissionsResult(activity, grantResults, permissions)
        } else {
            PermissionRequestResult.getIncorrectCode()
        }
    }

    companion object {
        const val PERMISSIONS_REQUEST_CODE = 43
    }

}