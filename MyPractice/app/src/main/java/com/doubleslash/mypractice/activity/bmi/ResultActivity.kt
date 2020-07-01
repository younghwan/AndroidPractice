package com.doubleslash.mypractice.activity.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doubleslash.mypractice.R
import kotlinx.android.synthetic.main.activity_result.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()

        val bmi = weight / Math.pow(height / 100.0, 2.0)

        when {
            bmi >= 35 -> tv_result.text = "고도 비만"
            bmi >= 30 -> tv_result.text = "2단계 비만"
            bmi >= 25 -> tv_result.text = "1단계 비만"
            bmi >= 23 -> tv_result.text = "과체중"
            bmi >= 18.5 -> tv_result.text = "정상"
            else -> tv_result.text = "저체중"
        }

        when {
            bmi >= 30 -> result_img.setImageResource(
                R.drawable.ic_sentiment_very_dissatisfied_black_24dp
            )
            bmi >= 23 -> result_img.setImageResource(
                R.drawable.ic_sentiment_dissatisfied_black_24dp
            )
            bmi >= 23 -> result_img.setImageResource(
                R.drawable.ic_sentiment_satisfied_black_24dp
            )
            else -> result_img.setImageResource(
                R.drawable.ic_sentiment_dissatisfied_black_24dp
            )
        }
    }
}
