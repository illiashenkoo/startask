package net.codecision.startask.permissions

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.spy
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.M])
class PermissionUtilsUnitTest {

    lateinit var activity: Activity

    @Before
    fun setup() {
        val activityController = Robolectric.buildActivity(Activity::class.java)
        activity = spy(activityController.setup().get())
    }

    @Test
    fun checkPermissionsActivity() {
        val result = PermissionUtils.checkPermissions(activity, arrayOf(Manifest.permission.CAMERA), 43, false)
        assertEquals(result.result, -1)
    }

    @Test
    fun verifyPermissionsResult() {

        var result = PermissionUtils.verifyPermissionsResult(
                IntArray(1) {
                    GRANTED
                }
        )
        assertTrue(result)

        //==================

        result = PermissionUtils.verifyPermissionsResult(
                IntArray(2) {
                    GRANTED
                    GRANTED
                }
        )
        assertTrue(result)

        //==================

        result = PermissionUtils.verifyPermissionsResult(
                IntArray(0)
        )
        assertFalse(result)

        //==================

        result = PermissionUtils.verifyPermissionsResult(
                IntArray(1) {
                    DENIED
                }
        )
        assertFalse(result)

        //==================

        result = PermissionUtils.verifyPermissionsResult(
                IntArray(2) {
                    GRANTED
                    DENIED
                }
        )
        assertFalse(result)

    }

    companion object {
        private const val GRANTED = PackageManager.PERMISSION_GRANTED
        private const val DENIED = PackageManager.PERMISSION_DENIED
    }
}