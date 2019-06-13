package net.codecision.startask.ktx.core.utils

object ClickController {

    var customClickIntervalMs: Long? = null

    private const val MIN_CLICK_INTERVAL_MS = 500L

    private var lastClickTime: Long = 0L

    fun isClickAllowed(): Boolean {
        val currentTime = getCurrentTimeMillis()
        val isClickAllowed = isClickAllowed(currentTime)

        if (isClickAllowed) {
            lastClickTime = currentTime
        }

        return isClickAllowed
    }

    private fun isClickAllowed(currentTime: Long): Boolean = (currentTime - lastClickTime) > getClickInterval()

    private fun getCurrentTimeMillis(): Long = System.currentTimeMillis()

    private fun getClickInterval(): Long {
        return customClickIntervalMs ?: MIN_CLICK_INTERVAL_MS
    }

}