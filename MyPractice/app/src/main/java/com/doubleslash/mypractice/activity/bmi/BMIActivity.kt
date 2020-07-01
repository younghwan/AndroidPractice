package com.doubleslash.mypractice.activity.bmi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doubleslash.mypractice.R
import kotlinx.android.synthetic.main.activity_bmi.*
import org.jetbrains.anko.startActivity

class BMIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        loadData()

        btn_result.setOnClickListener {

            saveData(et_height.text.toString().toInt(),et_weight.text.toString().toInt())

            startActivity<ResultActivity>(
                "weight" to et_weight.text.toString(),
                "height" to et_height.text.toString()
            )
        }

    }

    private fun saveData(height:Int,weight : Int){
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putInt("KEY_HEIGHT", height)
            putInt("KEY_WEIGHT", weight)
            commit()
        }
    }

    private fun loadData(){
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val height = sharedPref.getInt("KEY_HEIGHT", 0)
        val weight = sharedPref.getInt("KEY_WEIGHT", 0)

        if(height !=0 && weight !=0) {
            et_weight.setText(weight.toString())
            et_height.setText(height.toString())
        }
    }
}
