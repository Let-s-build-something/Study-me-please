package study.me.please.data.io

import android.os.Handler
import android.os.Looper

class Stopwatch {
    private var timeStarted : Long = 0
    private var timeElapsed : Long = 0
    private val handler = Handler(Looper.getMainLooper())

    fun addToTimeStarted(millis: Long) {
        timeStarted += millis
    }

    private var runnable: Runnable = object : Runnable {
        override fun run() {
            timeElapsed = System.currentTimeMillis() - timeStarted
            // Repeat every 0.1 second
            handler.postDelayed(this, 100)
        }
    }

    private fun startCoroutineTimer() {
        timeStarted = System.currentTimeMillis()
        handler.post(runnable)
    }

    fun reset(): Long {
        handler.removeCallbacks(runnable)
        val oldValue = timeElapsed.times(1)
        startCoroutineTimer()
        return oldValue
    }
}