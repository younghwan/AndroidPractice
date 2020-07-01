package com.doubleslash.mypractice.activity.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.doubleslash.mypractice.R
import kotlinx.android.synthetic.main.activity_stopwatch.*
import java.util.*
import kotlin.concurrent.timer

class StopwatchActivity : AppCompatActivity() {

    private var time = 0
    private var timerTask: Timer? = null
    private var isRunning = false
    private var lap = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)

        btn_start.setOnClickListener {
            isRunning = !isRunning

            if (isRunning) {
                start()
            } else {
                pause()
            }
        }

        btn_lab.setOnClickListener {
            recordLapTime()
        }

        btn_refresh.setOnClickListener {
            reset()
        }
    }

    private fun start() {
        btn_start.setImageResource(R.drawable.ic_pause_black_24dp)

        timerTask = timer(period = 10) {
            time++
            val sec = time / 100
            val milli = time % 100

            runOnUiThread {
                tv_sec.text = "$sec"
                tv_millisec.text = "$milli"
            }
        }
    }

    private fun pause() {
        btn_start.setImageResource(R.drawable.ic_play_arrow_black_24dp)
        timerTask?.cancel()
    }

    private fun recordLapTime() {
        val lapTime = this.time
        val textView = TextView(this)
        textView.textSize = 30f
        textView.text = "$lap LAP : ${lapTime / 100}.${lapTime % 100}"
        labtime_view.addView(textView, 0)
        lap++
    }

    private fun reset() {
        timerTask?.cancel()

        time = 0
        isRunning = false
        btn_start.setImageResource(R.drawable.ic_play_arrow_black_24dp)
        tv_millisec.text = "00"
        tv_sec.text = "0"

        labtime_view.removeAllViews()
        lap = 1
    }
}
